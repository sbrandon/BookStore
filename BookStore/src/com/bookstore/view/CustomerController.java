package com.bookstore.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.interceptor.SessionAware;

import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class CustomerController implements Preparable, SessionAware {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Customer customer;
	private SessionBeanFacadeLocal manageSessionBeanLocal;
	private PasswordHash passwordHash = new PasswordHash();
	private Map<String, Object> session;
	private List<Category> categories = new ArrayList<Category>();
	
	public void prepare(){
		session = ActionContext.getContext().getSession();
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (SessionBeanFacadeLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String login(){
		customer = manageSessionBeanLocal.authenticate(email);
		if(passwordHash.authenticate(customer.getPassword(), customer.getSalt(), password)){
			session.put("customer", customer);
			listCategories();
			return "success";
		}
		else{
			return "error";
		}
	}
	
	//Logout User
	public String logout(){
		session = ActionContext.getContext().getSession();
		session.remove("customer");
		session.clear();
		return "success";
	}
	
	//Register a new user
	public String register(){
		HashMap<String, String> map = passwordHash.hashPassword(password);
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(map.get("password"));
		customer.setSalt(map.get("salt"));
		manageSessionBeanLocal.persist(customer);
		session = ActionContext.getContext().getSession();
		session.put("customer", customer);
		listCategories();
		return "success";
	}
		
	//Populate list of categories
	public void listCategories(){
		categories = manageSessionBeanLocal.getCategories();
	}

	//Getters & Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SessionBeanFacadeLocal getManageSessionBeanLocal() {
		return manageSessionBeanLocal;
	}

	public void setManageSessionBeanLocal(
			SessionBeanFacadeLocal manageSessionBeanLocal) {
		this.manageSessionBeanLocal = manageSessionBeanLocal;
	}

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
