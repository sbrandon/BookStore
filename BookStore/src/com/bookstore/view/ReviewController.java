package com.bookstore.view;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class ReviewController implements Preparable {
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private Customer customer;
	private String rating;
	private String review;
	private String bookId;
	
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		customer = (Customer) session.get("customer");
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Add a review. must relate a book and person.
	public String addReview(){
		int id = Integer.parseInt(bookId);
		Book book = getBook(id);
		Review bookReview = new Review();
		bookReview.setReview(review);
		int starRating = Integer.parseInt(rating);
		bookReview.setRating(starRating);
		bookReview.setCustomer(customer);
		bookReview.setBook(book);
		manageSessionBeanLocal.persist(bookReview);
		return "success";
	}
	
	//Get book object with ID
	public Book getBook(int bookId){
		return manageSessionBeanLocal.findBookById(bookId);
	}
	
	//List all reviews associated with book
	public void listReviews(){
		
	}

	//Getters & Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
