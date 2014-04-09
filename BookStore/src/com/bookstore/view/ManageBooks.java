package com.bookstore.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class ManageBooks implements Preparable{
	
	private Map<String, Object> session;
	private ManageSessionBeanLocal manageSessionBeanLocal;
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
	
	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String listCategories(){
		categories = manageSessionBeanLocal.getCategories();
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
		manageSessionBeanLocal.persist(book);
		return "success";
	}
	
	//Return a category object from its id
	public Category findCategory(int category_id){
		Category category = manageSessionBeanLocal.findCategoryById(category_id);
		return category;
	}
	
	//Get Book object
	public String fetchBook(){
		int id = Integer.parseInt(bookId);
		book = manageSessionBeanLocal.findBookById(id);
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
	
}
