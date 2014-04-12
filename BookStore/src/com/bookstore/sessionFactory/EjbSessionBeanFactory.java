/*
 * This class represents a singleton object.
 * The constructor is private to prevent the class 
 * from being instantiated. The method get 
 * SessionBeanInstance() provides the requesting
 * class with an instance of the singleton object.
 */
package com.bookstore.sessionFactory;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.session.SessionBeanFacadeLocal;

public class EjbSessionBeanFactory {

	private static Context context;
	private static SessionBeanFacadeLocal sessionBean;
	
	//Private constructor to prevent class being instantiated
	private EjbSessionBeanFactory(){
		
	}
	
	//Return EJB Session Bean
	public static SessionBeanFacadeLocal getSessionBeanInstance(){
		try{
			Context context = new InitialContext();
			sessionBean = (SessionBeanFacadeLocal) context.lookup("SessionBeanFacade/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sessionBean;
	}
	
}
