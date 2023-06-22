package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Book extends BaseEntity{
//Author :id first name ,last name , email(unique) , pwd + ???????
//	Book : id,title(unique), price + ?????
	
	@Column(length = 30,unique = true)
	private String title;
	@Column(name="Book_price")
	private double price;
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	
}
