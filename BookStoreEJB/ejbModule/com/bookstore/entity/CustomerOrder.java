package com.bookstore.entity;
	
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries( {
	@NamedQuery(name = "CustomerOrder.findAll", query = "select o from CustomerOrder o"),
})

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToMany
	@JoinColumn(name="order_id")
	private List <LineItem> lineItems;
	@ManyToOne
	private Customer customer;
	
	//Constructor
	public CustomerOrder(){
		
	}

	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}