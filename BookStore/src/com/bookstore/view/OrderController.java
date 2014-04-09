package com.bookstore.view;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Customer;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class OrderController implements Preparable{
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private Customer customer;
	
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Confirm Order
	public String confirmOrder(){
		return "success";
	}
	
	//Get Customer From Session
	public String fetchCustomer(){
		customer = (Customer) session.get("customer");
		return "success";
	}
	
	//Getters & Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
