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

@NamedQueries({
	@NamedQuery(name = "Book.findAll", query="select o from Book o"),
	@NamedQuery(name = "Book.findById", query="select o from Book o where o.id=:book_id"),
	@NamedQuery(name = "Book.findByTitle", query = "select o from Book o where o.title like :search_title"),
	@NamedQuery(name = "Book.findByAuthor", query = "select o from Book o where o.author like :search_author"),
	@NamedQuery(name = "Book.findByCategory", query = "select o from Book o where o.category.categoryTitle like :search_category"),
	@NamedQuery(name = "Book.findByCategoryId", query = "select o from Book o where o.category.id=:catId"),
})

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String author;
	private double price;
	private String isbn;
	private String image;
	private String description;
	private int stockQuantity;
	@ManyToOne
	private Category category;
	@OneToMany
	@JoinColumn(name="book_id")
	private List<LineItem> lineitems;
	@OneToMany
	@JoinColumn(name="book_id")
	private List<Review> reviews;

	//Constructor
	public Book(){
		
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<LineItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}

}