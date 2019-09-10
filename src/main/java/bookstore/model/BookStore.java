package bookstore.model;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

@Alias("MyBS")
public class BookStore {

	private int bnum;
	private String title;
	private String category;
	private String author;
	private String translator;
	private String publisher;
	@NotNull(message="�븘�닔")
	private String ISBN;
	private int page;
	private String pub_date;
	private int price;
	private int stock;
	private String introduce;
	private int quantity;
	
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BookStore [bnum=" + bnum + ", title=" + title + ", category=" + category + ", author=" + author
				+ ", translator=" + translator + ", publisher=" + publisher + ", ISBN="
				+ ISBN + ", page=" + page + ", price=" + price + ", stock=" + stock + ", introduce=" + introduce + "]";
	}
	
	
	
}
