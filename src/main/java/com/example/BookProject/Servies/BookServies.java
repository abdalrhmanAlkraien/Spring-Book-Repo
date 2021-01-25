package com.example.BookProject.Servies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookProject.Model.Book;
import com.example.BookProject.Model.BookDTO;
import com.example.BookProject.Model.AuthorModel.Author;
import com.example.BookProject.Repostory.BookRepo;
import com.example.BookProject.Repostory.AuthorRepo.IAuthorRepo;
import com.sun.xml.bind.v2.TODO;

@Service

public class BookServies {
	// i am inject BookRepo Here

	private BookRepo bookRepo;

	@Autowired
	BookServies(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Autowired
	IAuthorRepo authRepo;

	public BookServies(IAuthorRepo authorRepo) {
		// TODO Auto-generated constructor stub

		this.authRepo = authorRepo;
	}

	//////////////////////////// Get Data Base ////////////////////////////

	// find all Book
	public List<BookDTO> FindAllBook() {

		List<Book> list=bookRepo.findAll();
		List<BookDTO> book=new ArrayList<BookDTO>();
		
		list.forEach(x->{
			book.add(x.toDto());
			
		});
		return book;

	}

	// find ById Book

	public BookDTO FindById(Long id) {
		Book book = bookRepo.findById(id).get();
		BookDTO toDto = book.toDto();
		return toDto;
	}

	public BookDTO findBooktitle(String title) {
		Book book = bookRepo.findByTitle(title).get();
		BookDTO toDto = book.toDto();
		return toDto;
	}

	//////////////////////////// Update Data Base ////////////////////////////

	// Add new Book
	public void AddBook(BookDTO newBook, Long id) {

		Author auth = authRepo.findById(id).get();
		newBook.setAuthor(auth.toDto());
		Book book = newBook.getEntity();
		bookRepo.save(book);
	}

	public void DeleteBook(Long id) {
		bookRepo.deleteById(id);
	}

	public void EditBook(BookDTO editBook, long Authid) {
		Optional<Author> authorOpt = authRepo.findById(Authid);

		authorOpt.ifPresent(author -> {
			author.getBooks().forEach(book -> {
				if (book.getId() == editBook.getId()) {
					book.setDecription(editBook.getDecription());
					book.setTitle(editBook.getTitle());
					bookRepo.save(book);
				}
			});
		});

//		if (authorOpt.isPresent()) {
//			if (bookRepo.findById(bookId).isPresent()) {
//				Book book = bookRepo.findById(bookId).get();
//				// Book book=editBook.getEntity();
//				// Book edit=editBook.getEntity();
//				book.setAuthor(editBook.getAuthor());
//				book.setDecription(editBook.getDecription());
//				book.setTitle(editBook.getTitle());
//				book.setId(editBook.getId());
//				bookRepo.save(book);
//
//			}
//		}

	}

	
	//////////////////////////Opreating DataBase///////////////////////////////
	public int  CountBook()
	{
		List<Book> list=bookRepo.findAll();
		List<BookDTO> dtolist=new ArrayList<BookDTO>();
		list.forEach(x->{
			dtolist.add(x.toDto());
		});
		
		return dtolist.size();
	}
}
