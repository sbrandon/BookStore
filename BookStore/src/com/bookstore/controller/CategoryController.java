/*
 * Class CategoryController
 */
package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Administrator;
import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class CategoryController implements Preparable{
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private Map<String, Object> session;
	private String categoryTitle;
	private Customer customer;
	private List<Category> categories = new ArrayList<Category>();
	private Administrator admin;

	@Override
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		customer = (Customer) session.get("customer");
		admin = (Administrator) session.get("admin");
	}
	
	//Persist Category to Database
	public String addCategory(){
		Category category = new Category();
		category.setCategoryTitle(categoryTitle);
		ejbSessionBean.persist(category);
		return "success";
	}
	
	public String shopHome(){
		categories = ejbSessionBean.getCategories();
		return "success";
	}
	
	//Getters & Setters
	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
}
