package com.bookstore.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class CustomerRegistration implements Preparable {
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Map<String, Object> session;
	private PasswordHash passwordHash = new PasswordHash();
	private List<Category> categories = new ArrayList<Category>();
	
	@Override
	public void prepare() throws Exception {
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Register a new user
	public String register(){
		HashMap<String, String> map = passwordHash.hashPassword(password);
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(map.get("password"));
		manageSessionBeanLocal.persist(customer);
		session = ActionContext.getContext().getSession();
		session.put("customer", customer);
		return "success";
	}
	
	//Populate list of categories
	public void listCategories(){
		categories = manageSessionBeanLocal.getCategories();
	}

	//Getters & Setters
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public PasswordHash getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
