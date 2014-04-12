/*
 * This class implements an interface to allow clients
 * to execute operations on entity beans. This class forms 
 * part of the Facade pattern.
 */
package com.bookstore.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.LineItem;
import com.bookstore.entity.Review;

@Stateless
public class SessionBeanFacade implements SessionBeanFacadeLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//Persist object to database
	public boolean persist(Object object) {
		entityManager.persist(object);
		return true;
	}
	
	//Merge Object
	public boolean merge(Object object){
		entityManager.merge(object);
		return true;
	}
	
	//Return list of categories
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try{
			categories = (List<Category>) entityManager.createNamedQuery("Category.findAll").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return categories;
	}
	
	//Find books by title.
	@SuppressWarnings("unchecked")
	public List<Book> findBookByTitle(String title) {
		List<Book> books = new ArrayList<Book>();
		try{
			books = (List<Book>) entityManager.createNamedQuery("Book.findByTitle").setParameter("search_title", "%" + title + "%").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}
	
	//Find books by author.
	@SuppressWarnings("unchecked")
	public List<Book> findBookByAuthor(String author) {
		List<Book> books = new ArrayList<Book>();
		try{
			books = (List<Book>) entityManager.createNamedQuery("Book.findByAuthor").setParameter("search_author", "%" + author + "%").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}
	
	//Find books by category title
	@SuppressWarnings("unchecked")
	public List<Book> findBookByCategory(String category) {
		List<Book> books = new ArrayList<Book>();
		try{
			books = (List<Book>) entityManager.createNamedQuery("Book.findByCategory").setParameter("search_category", "%" + category + "%").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}
	
	//Return a category object with matching title
	public Category findCategoryById(int category_id) {
		Category category = (Category) entityManager.createNamedQuery("Category.findById").setParameter("category_id", category_id).getSingleResult();
		return category;
	}
	
	//Find a book by its ID
	public Book findBookById(int book_id) {
		Book book = (Book) entityManager.createNamedQuery("Book.findById").setParameter("book_id", book_id).getSingleResult();
		return book;
	}
	
	//Return a customer object by email, used for authentication purposes.
	public Customer authenticate(String email) {
		Customer customer = (Customer) entityManager.createNamedQuery("Customer.authenticate").setParameter("email", email).getSingleResult();
		return customer;
	}
	
	//Return a list of line items in a cart. 
	@SuppressWarnings("unchecked")
	public List<LineItem> findLineItemByCart(int cartId) {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		try{
			lineItems = (List<LineItem>) entityManager.createNamedQuery("LineItem.findByCartId").setParameter("cart_id", cartId).getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return lineItems;
	}
	
	//Delete Cart
	public boolean deleteCart(int cartId) {
		entityManager.createNamedQuery("Cart.remove").setParameter("cart_id", cartId).executeUpdate();
		return true;
	}

	//Get reviews belonging to a book
	@SuppressWarnings("unchecked")
	public List<Review> getBookReviews(int bookId) {
		List<Review> reviews = new ArrayList<Review>();
		try{
			reviews = (List<Review>) entityManager.createNamedQuery("Review.findByBook").setParameter("book_id", bookId).getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return reviews;
	}
	
	//Remove a lineItem with matching ID
	public boolean removeLineItem(int itemId) {
		entityManager.createNamedQuery("LineItem.remove").setParameter("item_id", itemId).executeUpdate();
		return true;
	}
	
	

}
