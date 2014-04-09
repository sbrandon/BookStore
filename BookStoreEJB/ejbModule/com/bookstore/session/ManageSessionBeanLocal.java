package com.bookstore.session;

import java.util.List;

import javax.ejb.Local;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.LineItem;

@Local
public interface ManageSessionBeanLocal {
	//Persist Object
	public boolean persist(Object object);
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
}
