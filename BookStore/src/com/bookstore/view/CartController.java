package com.bookstore.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.LineItem;
import com.bookstore.session.ManageSessionBeanLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

public class CartController implements Preparable {
	
	private ManageSessionBeanLocal manageSessionBeanLocal;
	private Map<String, Object> session;
	private Cart cart;
	private String bookId;
	private String quantity;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	
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
	
	//Add a book to cart
	public String addToCart(){
		if(session.get("cart") != null){
			cart = (Cart) session.get("cart");
		}
		else{
			cart = new Cart();
			session.put("cart", cart);
			manageSessionBeanLocal.persist(cart);
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
		Book book = manageSessionBeanLocal.findBookById(id);
		return book;
	}
	
	//Create LineItem
	public boolean newLineItem(Book book){
		int purchaseQuantity = Integer.parseInt(quantity);
		if(book.getStockQuantity() >= purchaseQuantity){
			LineItem lineItem = new LineItem();
			lineItem.setCart(cart);
			lineItem.setBook(book);
			lineItem.setQuantity(purchaseQuantity);
			manageSessionBeanLocal.persist(lineItem);
			return true;
		}
		else{
			return false;
		}
	}
	
	//Get the lineItems with this cart ID
	public void listCartItems(){
		lineItems = manageSessionBeanLocal.findLineItemByCart(cart.getId());
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

}
