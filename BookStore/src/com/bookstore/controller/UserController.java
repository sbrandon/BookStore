/*
 * Class UserController Implements Strategy Pattern by creating instances of userContext
 * and executing operations on those instances.
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
import com.bookstore.userStrategy.AdminManager;
import com.bookstore.userStrategy.CustomerManager;
import com.bookstore.userStrategy.UserContext;
import com.opensymphony.xwork2.Preparable;

public class UserController implements Preparable{

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Administrator admin;
	private Customer customer;
	private Map<String, Object> session;
	private SessionBeanFacadeLocal ejbSessionBean;
	private List<Category> categories = new ArrayList<Category>();
	private List<Customer> customers = new ArrayList<Customer>();
	
	@Override
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
	}
	
	//Administrator Log In
	public String adminLogin(){
		UserContext context = new UserContext(new AdminManager());
		if(context.login(email, password)){
			admin = (Administrator) session.get("admin");
			return "success";
		}
		else{
			return "error";
		}
	}
	
	//Administrator Log Out
	public String adminLogout(){
		UserContext context = new UserContext(new AdminManager());
		context.logout();
		return "success";
	}
	
	//Administrator Register
	public String adminRegister(){
		UserContext context = new UserContext(new AdminManager());
		context.register(email, password, firstName, lastName);
		admin = (Administrator) session.get("admin");
		return "success";
	}
	
	//Get Administrator from session
	public String getAdminSession(){
		admin = (Administrator) session.get("admin");
		return "success";
	}
	
	//Customer Log In
	public String custLogin(){
		UserContext context = new UserContext(new CustomerManager());
		if(context.login(email, password)){
			customer = (Customer) session.get("customer");
			listCategories();
			return "success";
		}
		else{
			return "error";
		}
	}
	
	//Customer Log Out
	public String custLogout(){
		UserContext context = new UserContext(new CustomerManager());
		context.logout();
		return "success";
	}
	
	//Customer Register
	public String custRegister(){
		UserContext context = new UserContext(new CustomerManager());
		context.register(email, password, firstName, lastName);
		customer = (Customer) session.get("customer");
		listCategories();
		return "success";
	}
	
	//Get All Customers For Administrator View
	public String getAllCustomers(){
		customers = ejbSessionBean.getAllCustomers();
		return "success";
	}
	
	//Populate list of categories
	public void listCategories(){
		categories = ejbSessionBean.getCategories();
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

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
