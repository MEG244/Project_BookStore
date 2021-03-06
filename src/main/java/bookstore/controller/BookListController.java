package bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookstore.model.BookStore;
import bookstore.model.BookStoreDao;
import utility.Paging;

@Controller
public class BookListController {
	
	private static final String command = "/list.bs";
	private static final String getPage= "BookList";
	
	@Autowired
	@Qualifier("myBookStoreDao")
	private BookStoreDao bookStoreDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value = "category", required = false) String category, 
			@RequestParam(value = "keyword", required = false) String keyword, 
			@RequestParam(value = "sorting", required = false) String sorting, 
			@RequestParam(value = "pageNumber", required = false ) String pageNumber,
			@RequestParam(value = "pageSize", required = false ) String pageSize,
			HttpServletRequest request
			) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("keyword", "%"+keyword+"%");
		map.put("sorting",sorting);
		
		ModelAndView mav = new ModelAndView();
		
		
		int totalCount = bookStoreDao.GetTotalCount(map);
		String url = request.getContextPath() + "/" + command;
		
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, category, keyword, null);
		
		List<BookStore> bookLists = bookStoreDao.GetDataList(pageInfo,map); 
		mav.addObject("bookLists",bookLists);
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageInfo",pageInfo);

		if(keyword != null) {
			mav.addObject("keyword",keyword);
		}
		
		mav.setViewName(getPage);
		return mav;
		
	}
	
	
	
	
	
	
}
