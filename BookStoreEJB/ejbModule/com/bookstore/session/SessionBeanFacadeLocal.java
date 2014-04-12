/*
 * This is an interface for the session bean which allows 
 * the client to execute operations on the entity beans. 
 * This interface forms part of the Facade pattern sometimes
 * refered to as the session facade pattern in J2EE.
 */
package com.bookstore.session;

import java.util.List;

import javax.ejb.Local;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.CustomerOrder;
import com.bookstore.entity.LineItem;
import com.bookstore.entity.Review;

@Local
public interface SessionBeanFacadeLocal {
	//Persist Object
	public boolean persist(Object object);
	//Merge Object
	public boolean merge(Object object);
	//Category
	public List<Category> getCategories();
	public Category findCategoryById(int category_id);
	//Book
	public List<Book> findBookByTitle(String title);
	public List<Book> findBookByAuthor(String author);
	public List<Book> findBookByCategory(String category);
	public Book findBookById(int book_id);
	//Customer
	public Customer authenticate(String email);
	//LineItem
	public List<LineItem> findLineItemByCart(int cartId);
	public boolean removeLineItem(int itemId);
	//Cart
	public boolean deleteCart(int cartId);
	//Review
	public List<Review> getBookReviews(int bookId);
	//CustomerOrder
	public List<CustomerOrder> getOrders();
}
