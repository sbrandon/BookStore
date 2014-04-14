package com.bookstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookstore.entity.Administrator;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class AdminController implements Preparable, SessionAware{
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private PasswordHash passwordHash = new PasswordHash();
	private Map<String, Object> session;
	private Administrator admin;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public void prepare(){
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		admin = (Administrator) session.get("admin");
	}
	
	//Login
	public String login(){
		admin = ejbSessionBean.authenticateAdmin(email);
		if(passwordHash.authenticate(admin.getPassword(), admin.getSalt(), password)){
			session.put("admin", admin);
			return "success";
		}
		else{
			return "error";
		}
	}
	
	//Logout Administrator
	public String logout(){
		session = ActionContext.getContext().getSession();
		session.remove("admin");
		session.clear();
		return "success";
	}
	
	//Register a new user
	public String register(){
		HashMap<String, String> map = passwordHash.hashPassword(password);
		Administrator admin = new Administrator();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setPassword(map.get("password"));
		admin.setSalt(map.get("salt"));
		ejbSessionBean.persist(admin);
		session = ActionContext.getContext().getSession();
		session.put("admin", admin);
		return "success";
	}
	
	public String execute(){
		return "success";
	}
	
	//Getters & Setters
	public void setSession(Map<String, Object> arg0) {
		
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
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
