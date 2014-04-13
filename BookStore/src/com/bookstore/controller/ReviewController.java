/*
 * Class ReviewController
 */
package com.bookstore.controller;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class ReviewController implements Preparable {
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private Map<String, Object> session;
	private Customer customer;
	private String rating;
	private String review;
	private String bookId;
	private Book book;
	private List<Review> reviews = new ArrayList<Review>();
	
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		customer = (Customer) session.get("customer");
	}
	
	//Add a review. must relate a book and person.
	public String addReview(){
		int id = Integer.parseInt(bookId);
		book = getBook(id);
		Review bookReview = new Review();
		bookReview.setReview(review);
		int starRating = Integer.parseInt(rating);
		bookReview.setRating(starRating);
		bookReview.setCustomer(customer);
		bookReview.setBook(book);
		bookReview.setDate(getDate());
		ejbSessionBean.persist(bookReview);
		getBookReviews(id);
		return "success";
	}
	
	//Get Today's Date
	public String getDate(){
		String date;
		DateFormatSymbols symbols = new DateFormatSymbols();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int dateNumber = calendar.get(Calendar.DAY_OF_MONTH);
		String[] months = symbols.getMonths();
		String[] days = symbols.getWeekdays();
		String dayText = days[day];
		String monthText = months[month];
		date = dayText + " " + monthText + " " + dateNumber + " " + Integer.toString(year);
		return date;
	}
	
	//Get Book Reviews
	public void getBookReviews(int bookId){
		reviews = ejbSessionBean.getBookReviews(bookId);
	}
	
	//Get book object with ID
	public Book getBook(int bookId){
		return ejbSessionBean.findBookById(bookId);
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
