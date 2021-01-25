package com.example.BookProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookProject.Model.Book;
import com.example.BookProject.Model.BookDTO;
import com.example.BookProject.Servies.BookServies;

@RestController
@RequestMapping(value = "api/book")
public class BookController {
	// inject servies

	private BookServies book;

	@Autowired
	public BookController(BookServies book) {
		// TODO Auto-generated constructor stub

		this.book = book;
	}

	//////////////////////////// Get Data Base ////////////////////////////

	// find all book
	@GetMapping(value = "/allBook")
	public List<BookDTO> AllBook() {
		return book.FindAllBook();
	}

	// Find Book By Id
	@GetMapping(value = "bookId/{id}")
	public BookDTO FindBook(@PathVariable Long id) {
		return book.FindById(id);
	}

	@GetMapping(value = "bookTitle/{title}")
	public BookDTO findBookBytitle(@PathVariable String title) {
		return book.findBooktitle(title);
	}

	//////////////////////////// Update Data Base ////////////////////////////

	// Add New Book Method
	@PostMapping(value = "/addBook/{session}")
	public void AddBook(@RequestBody BookDTO NewBook, @PathVariable long session) {
		book.AddBook(NewBook, session);

	}

	// DeleteBook By Id
	@GetMapping(value = "/deleteId/{id}")
	public void DeleteBook(@PathVariable Long id) {
		book.DeleteBook(id);
	}

	@PostMapping(value = "/editBook/{authid}")
	public void EditBook(@RequestBody BookDTO dto, @PathVariable long authid) {
		book.EditBook(dto, authid);
	}
	
	//////////////////////////Opreating DataBase///////////////////////////////
	@GetMapping(value = "/getCount")
	public int getBookcount() {
		return book.CountBook();
	}

}
