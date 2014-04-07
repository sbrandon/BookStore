package com.bookstore.session;

import java.util.List;

import javax.ejb.Local;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

@Local
public interface ManageSessionBeanLocal {
	//Persist Object
	public boolean persist(Object object);
	//Category
	public List<Category> getCategories();
	//Book
	public List<Book> findByTitle(String title);
	public List<Book> findByAuthor(String author);
	public List<Book> findByCategory(String category);
}
