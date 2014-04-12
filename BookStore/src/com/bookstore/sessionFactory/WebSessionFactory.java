/*
 * This class represents a singleton object.
 * The constructor is private to prevent the class 
 * from being instantiated. The method get 
 * WebSessionIntance() provides the requesting
 * class with an instance of the singleton object.
 */
package com.bookstore.sessionFactory;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class WebSessionFactory {
	
	private static Map<String, Object> session;
	
	//Private constructor to prevent class being instantiated
	private WebSessionFactory(){
		
	}
	
	//Return session
	public static Map<String, Object> getWebSessionInstance(){
		session = ActionContext.getContext().getSession();
		return session;
	}
}
