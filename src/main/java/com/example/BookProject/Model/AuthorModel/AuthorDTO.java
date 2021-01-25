package com.example.BookProject.Model.AuthorModel;

import java.util.List;

import com.example.BookProject.Model.BookDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthorDTO {

	private long id;
	private String firstname;
	private String lastName;
	private List<BookDTO> books;

//	public DtoAuthor() {
//		super();
//	}
//
//	public DtoAuthor(long id, String firstname, String lastName, List<DtoBook> books) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastName = lastName;
//		this.books = books;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	@JsonIgnore
	public Author toEntity() {
		Author auth = new Author();
		auth.setId(this.id);
		auth.setFirstname(this.firstname);
		auth.setLastName(this.lastName);
		// auth.setBooks(this.books);
		return auth;
	}

}
