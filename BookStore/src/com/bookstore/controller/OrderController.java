/*
 * Class OrderController
 */
package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.entity.LineItem;
import com.bookstore.entity.CustomerOrder;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class OrderController implements Preparable{
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private Map<String, Object> session;
	private Customer customer;
	private Cart cart;
	private String address1;
	private String address2;
	private String address3;
	private String town;
	private String county;
	private String phoneNumber;
	private List <CustomerOrder> orders = new ArrayList<CustomerOrder>();
	
	@Override
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		customer = (Customer) session.get("customer");
		cart = (Cart) session.get("cart");
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
		ejbSessionBean.merge(customer);
	}
	
	//Create a new order
	public CustomerOrder createOrder(){
		CustomerOrder order = new CustomerOrder();
		order.setCustomer(customer);
		ejbSessionBean.persist(order);
		return order;
	}
	
	//Add LineItems to order
	public void addLineItems(CustomerOrder order){
		List <LineItem> lineItems = new ArrayList<LineItem>();
		lineItems = ejbSessionBean.findLineItemByCart(cart.getId());
		for(LineItem lineItem : lineItems){
			lineItem.setOrder(order);
			lineItem.setCart(null);
			updateStockLevels(lineItem.getBook(), lineItem.getQuantity());
			ejbSessionBean.merge(lineItem);
		}
	}
	
	//Get all orders for administrator
	public String getAllOrders(){
		orders = ejbSessionBean.getOrders();
		return "success";
	}
	
	//Update Stock Levels of Book
	public void updateStockLevels(Book book, int quantity){
		int originalStock = book.getStockQuantity();
		int newStock = originalStock - quantity;
		book.setStockQuantity(newStock);
		ejbSessionBean.merge(book);
	}
	
	//Remove Cart
	public void removeCart(){
		ejbSessionBean.deleteCart(cart.getId());
	}
	
	//Blank method to allow view to get session values.
	public String confirmOrder(){
		return "success";
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

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}
	
}
