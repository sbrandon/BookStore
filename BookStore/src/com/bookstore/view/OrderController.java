package com.bookstore.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.entity.LineItem;
import com.bookstore.entity.CustomerOrder;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class OrderController implements Preparable{
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private Customer customer;
	private Cart cart;
	private String address1;
	private String address2;
	private String address3;
	private String town;
	private String county;
	private String phoneNumber;
	
	@Override
	public void prepare() throws Exception {
		session = ActionContext.getContext().getSession();
		customer = (Customer) session.get("customer");
		cart = (Cart) session.get("cart");
		try{
			Context context = new InitialContext();
			manageSessionBeanLocal = (ManageSessionBeanLocal) context.lookup("ManageSessionBean/local");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Confirm Order
	public String placeOrder(){
		updateCustomer();
		addLineItems(createOrder());
		removeCart();
		return "success";
	}
	
	//Update Customer Details
	public void updateCustomer(){
		customer.setAddressLine1(address1);
		customer.setAddressLine2(address2);
		customer.setAddressLine3(address3);
		customer.setTown(town);
		customer.setPhoneNumber(phoneNumber);
		manageSessionBeanLocal.merge(customer);
	}
	
	//Create a new order
	public CustomerOrder createOrder(){
		CustomerOrder order = new CustomerOrder();
		order.setCustomer(customer);
		manageSessionBeanLocal.persist(order);
		return order;
	}
	
	//Add LineItems to order
	public void addLineItems(CustomerOrder order){
		List <LineItem> lineItems = new ArrayList<LineItem>();
		lineItems = manageSessionBeanLocal.findLineItemByCart(cart.getId());
		for(LineItem lineItem : lineItems){
			lineItem.setOrder(order);
			lineItem.setCart(null);
			updateStockLevels(lineItem.getBook(), lineItem.getQuantity());
			manageSessionBeanLocal.merge(lineItem);
		}
	}
	
	//Update Stock Levels of Book
	public void updateStockLevels(Book book, int quantity){
		int originalStock = book.getStockQuantity();
		int newStock = originalStock - quantity;
		book.setStockQuantity(newStock);
		manageSessionBeanLocal.merge(book);
	}
	
	//Remove Cart
	public void removeCart(){
		manageSessionBeanLocal.deleteCart(cart.getId());
	}
	
	//Getters & Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
