package bookstore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import utility.Paging;

@Component("myBookStoreDao")
public class BookStoreDao {

	private final String namespace = "bookstore.model.BookStore";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int GetTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return cnt;
	}
	
	public List<BookStore> GetDataList(Paging pageInfo,Map<String, String> map){
		List<BookStore> lists = new ArrayList<BookStore>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace + ".GetDataList", map,rowBounds );
		
		for(BookStore bs : lists) {
			String pub_day = sqlSessionTemplate.selectOne(namespace+".GetPubDate", bs.getTitle());
			bs.setPub_date(pub_day);
		}
		
		for(BookStore bs : lists) {
			if(bs.getIntroduce() == null || bs.getIntroduce().equals("")) {
				BookCrawler crawler = new BookCrawler();
				String content = crawler.bookContentCrawler(bs.getISBN());
				Map<String,String> bookInfo = new HashMap<String, String>();
				bookInfo.put("title", bs.getTitle());
				bookInfo.put("introduce", content);
				sqlSessionTemplate.update(namespace+".UpdateIntroduce",bookInfo);
			}
		}
		
		return lists;
		
	}
	
	public void InsertData(String ISBN) {
		BookCrawler crawler = new BookCrawler();
		BookStore bean = crawler.bookCrawlerByISBNResult(ISBN);
		
		sqlSessionTemplate.insert(namespace+".InsertData",bean);
	}
	
	public BookStore GetData(int bnum) {
		BookStore book = sqlSessionTemplate.selectOne(namespace+".GetData",bnum);
		return book;
	}
	
	public Map<String,String> GetContent(BookStore book){
		BookCrawler crawler = new BookCrawler();
		Map<String,String> map =crawler.crawlContent(book.getISBN());
		
		return map;
	}
	
	public void updateStock(Integer bnum, Integer qty) {
		BookStore bean = new BookStore();
		bean.setBnum(bnum);
		bean.setStock(qty);
		
		sqlSessionTemplate.update(namespace + ".updateStock", bean);
	}
	
	
}
