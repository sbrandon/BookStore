/*
 * Class BookController 
 */
package com.bookstore.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class BookController implements Preparable{
	
	private Map<String, Object> session;
	private SessionBeanFacadeLocal ejbSessionBean;
	private String title;
	private String author;
	private String isbn;
	private String description;
	private double price;
	private String category;
	private String image;
	private int stockQuantity;
	private List <Category> categories = new ArrayList<Category>();
	private Book book;
	private String bookId;
	private String searchObject;
	private String searchString;
	private List<Book> books = new ArrayList<Book>();
	private List<Review> reviews = new ArrayList<Review>();
	private Customer customer;
	
	@Override
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		customer = (Customer) session.get("customer");
	}
	
	public String listCategories(){
		categories = ejbSessionBean.getCategories();
		return "success";
	}
	
	public String addBook(){
		Book book = new Book();
		int categoryId = Integer.parseInt(category);
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setPrice(price);
		book.setIsbn(isbn);
		book.setCategory(findCategory(categoryId));
		book.setImage(image);
		book.setStockQuantity(stockQuantity);
		ejbSessionBean.persist(book);
		return "success";
	}
	
	//Return a category object from its id
	public Category findCategory(int category_id){
		Category category = ejbSessionBean.findCategoryById(category_id);
		return category;
	}
	
	//Get Book object
	public String fetchBook(){
		int id = Integer.parseInt(bookId);
		book = ejbSessionBean.findBookById(id);
		getBookReviews(id);
		return "success";
	}
	
	//Get Book Reviews
	public void getBookReviews(int bookId){
		reviews = ejbSessionBean.getBookReviews(bookId);
	}
	
	//Search Books
	public String searchBooks(){
		if(searchObject.equals("author")){
			books = ejbSessionBean.findBookByAuthor(searchString);
		}
		else if(searchObject.equals("title")){
			books = ejbSessionBean.findBookByTitle(searchString);
		}
		else{
			books = ejbSessionBean.findBookByCategory(searchString);
		}
		return "success";
	}
	
	//Getters & Setters
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getSearchObject() {
		return searchObject;
	}

	public void setSearchObject(String searchObject) {
		this.searchObject = searchObject;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
