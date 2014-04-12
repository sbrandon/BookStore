package com.bookstore.view;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class CategoryController implements Preparable{
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private String categoryTitle;
	private Customer customer;

	@Override
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
	
	//Persist Category to Database
	public String addCategory(){
		Category category = new Category();
		category.setCategoryTitle(categoryTitle);
		manageSessionBeanLocal.persist(category);
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
	
}
