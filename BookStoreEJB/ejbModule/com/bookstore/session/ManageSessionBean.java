package com.bookstore.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;

@Stateless
public class ManageSessionBean implements ManageSessionBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//Persist object to database
	public boolean persist(Object object) {
		entityManager.persist(object);
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

	public Book findBookById(int book_id) {
		Book book = (Book) entityManager.createNamedQuery("Book.findById").setParameter("book_id", book_id).getSingleResult();
		return book;
	}

	public Customer authenticate(String email) {
		Customer customer = (Customer) entityManager.createNamedQuery("Customer.authenticate").setParameter("email", email).getSingleResult();
		return customer;
	}

}
