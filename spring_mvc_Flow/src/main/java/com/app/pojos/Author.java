package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Author extends BaseEntity {

	//Author :id first name ,last name , email(unique) , pwd + ???????
//	Book : id,title(unique), price + ?????
	@Column(name = "First_name",length = 20)
	private String firstName;
	@Column(name = "Last_name",length = 20)
	private String lastName;
	@Column(length =30,unique = true)
	private String email;
	@Column(name = "Password",length = 20,nullable = false)
	private String password;
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
	private List<Book> bookList=new ArrayList<>();
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Author(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
	//adding helper method to add new book
	public void addNewBook(Book b) {
		bookList.add(b);
		b.setAuthor(this);
	}
	public void deleteBook(Book b) {
		bookList.remove(b);
		b.setAuthor(null);
		
	}
	
}
