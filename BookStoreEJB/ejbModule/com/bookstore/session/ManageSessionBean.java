package com.bookstore.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

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
	public List<Book> findByTitle(String title) {
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
	public List<Book> findByAuthor(String author) {
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
	public List<Book> findByCategory(String category) {
		List<Book> books = new ArrayList<Book>();
		try{
			books = (List<Book>) entityManager.createNamedQuery("Book.findByCategory").setParameter("search_category", "%" + category + "%").getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return books;
	}

}
