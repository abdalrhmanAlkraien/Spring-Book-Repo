package com.example.BookProject.Model;

import com.example.BookProject.Model.AuthorModel.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO {

	private Long id;
	private String title;
	private String decription;
	private AuthorDTO author;

//	public DtoBook(Long id, String title, String decription, DtoAuthor author) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.decription = decription;
//		this.author = author;
//	}
//
//	public DtoBook() {
//		super();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	@JsonIgnore
	public Book getEntity() {
		Book book = new Book();
		book.setId(this.id);
		book.setTitle(this.title);
		book.setDecription(this.decription);

		book.setAuthor(this.author.toEntity());
		return book;
	}
}
