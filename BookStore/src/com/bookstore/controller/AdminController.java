package com.bookstore.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookstore.entity.Administrator;
import com.bookstore.security.PasswordHash;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class AdminController implements Preparable, SessionAware{
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private PasswordHash passwordHash = new PasswordHash();
	private Map<String, Object> session;
	private Administrator admin;
	private String email;
	private String password;
	
	public void prepare(){
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
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
	
	//Getters & Setters
	public void setSession(Map<String, Object> arg0) {
		
	}
	
}
