package com.example.BookProject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.BookProject.Model.AuthorModel.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String title;
	
	@Column()
	private String decription;
	
	@ManyToOne()
	@JsonIgnoreProperties(value = "books", allowSetters = true)
	Author author;
	
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author auth) {
		this.author = auth;
	}

	public Book(Long id, String title, String decription, Author auth) {
		super();
		this.id = id;
		this.title = title;
		decription = decription;
		this.author = auth;
	}

	public Book() {
		super();
	}

	public Book(Long id, String title, String decription) {
		super();
		this.id = id;
		this.title = title;
		decription = decription;
	}

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
	
	public BookDTO toDto() {
		BookDTO dto=new BookDTO();
		dto.setId(this.id);
		dto.setTitle(this.title);
		dto.setDecription(this.decription);
		dto.setAuthor(this.author.toDto());
		return dto;
	}

}
