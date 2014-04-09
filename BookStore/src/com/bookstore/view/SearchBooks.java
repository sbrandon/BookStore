package com.bookstore.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class SearchBooks implements Preparable {
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private Customer customer;
	private String searchObject;
	private String searchString;
	private List<Book> books = new ArrayList<Book>();
	
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		customer = (Customer) session.get("customer");
		try {  
			Context context = new InitialContext();  
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		} catch (NamingException e) {  
			e.printStackTrace();  
		} 
	}
	
	public String searchBooks(){
		if(searchObject.equals("author")){
			books = manageSessionBeanLocal.findBookByAuthor(searchString);
		}
		else if(searchObject.equals("title")){
			books = manageSessionBeanLocal.findBookByTitle(searchString);
		}
		else{
			books = manageSessionBeanLocal.findBookByCategory(searchString);
		}
		return "success";
	}

	//Getters & Setters
	public ManageSessionBeanLocal getManageSessionBeanLocal() {
		return manageSessionBeanLocal;
	}

	public void setManageSessionBeanLocal(
			ManageSessionBeanLocal manageSessionBeanLocal) {
		this.manageSessionBeanLocal = manageSessionBeanLocal;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

}
