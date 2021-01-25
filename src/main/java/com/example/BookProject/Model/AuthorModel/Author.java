package com.example.BookProject.Model.AuthorModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.example.BookProject.Model.Book;

@Entity
@Transactional
@Table(name = "Author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String firstname;

	@Column
	private String lastName;

	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL, fetch=FetchType.LAZY )
	private List<Book> books;
	


//	public authorModel(long id, String firstname, String lastName) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastName = lastName;
//	}
//
//	public authorModel(long id, String firstname, String lastName, List<Book> books) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastName = lastName;
//		this.books = books;
//	}

	public Author() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
	
	public AuthorDTO toDto() {
		AuthorDTO dto=new AuthorDTO();
		dto.setId(this.id);
		//dto.setBooks(this.books);
		dto.setFirstname(this.firstname);
		dto.setLastName(this.lastName);
		return dto;
	}

}
