/*
 * Class CartController
 */
package com.bookstore.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Customer;
import com.bookstore.entity.LineItem;
import com.bookstore.session.SessionBeanFacadeLocal;
import com.bookstore.sessionFactory.EjbSessionBeanFactory;
import com.bookstore.sessionFactory.WebSessionFactory;
import com.opensymphony.xwork2.Preparable;

public class CartController implements Preparable {
	
	private SessionBeanFacadeLocal ejbSessionBean;
	private Map<String, Object> session;
	private Cart cart;
	private String lineItemId;
	private String bookId;
	private String quantity;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	private Customer customer;
	private double total;
	
	public void prepare() throws Exception {
		session = WebSessionFactory.getWebSessionInstance();
		ejbSessionBean = EjbSessionBeanFactory.getSessionBeanInstance();
		customer = (Customer) session.get("customer");
		cart = (Cart) session.get("cart");
	}
	
	//Add a book to cart
	public String addToCart(){
		if(cart == null){
			cart = new Cart();
			session.put("cart", cart);
			ejbSessionBean.persist(cart);
		}
		if(fetchBook() != null){
			if(newLineItem(fetchBook())){
				listCartItems();
				return "success";
			}
			else{
				return "error";
			}
		}
		return "error";
	}
	
	//Get Book Object
	public Book fetchBook(){
		int id = Integer.parseInt(bookId);
		Book book = ejbSessionBean.findBookById(id);
		return book;
	}
	
	//Create LineItem
	public boolean newLineItem(Book book){
		lineItems = ejbSessionBean.findLineItemByCart(cart.getId());
		int purchaseQuantity = Integer.parseInt(quantity);
		if(book.getStockQuantity() >= purchaseQuantity){
			for(LineItem lineItem : lineItems){
				if(lineItem.getBook().getId() == book.getId()){
					int quantity = lineItem.getQuantity();
					quantity += purchaseQuantity;
					lineItem.setQuantity(quantity);
					lineItem.setLineTotal(book.getPrice() * purchaseQuantity);
					ejbSessionBean.merge(lineItem);
					return true;
				}
			}
			LineItem lineItem = new LineItem();
			lineItem.setCart(cart);
			lineItem.setBook(book);
			lineItem.setQuantity(purchaseQuantity);
			lineItem.setLineTotal(book.getPrice() * purchaseQuantity);
			ejbSessionBean.persist(lineItem);
			return true;
		}
		else{
			return false;
		}
	}
	
	//Get the lineItems with this cart ID
	public void listCartItems(){
		lineItems = ejbSessionBean.findLineItemByCart(cart.getId());
		calculateTotal();
	}
	
	//Calculate the total value of items in the cart
	public void calculateTotal(){
		total = 0.0;
		for(LineItem lineItem : lineItems){
			total += lineItem.getLineTotal();
		}
	}
	
	//Remove a line item from the cart
	public String removeItem(){
		int itemId = Integer.parseInt(lineItemId);
		ejbSessionBean.removeLineItem(itemId);
		listCartItems();
		return "success";
	}
	
	//Getters & Setters
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

}
