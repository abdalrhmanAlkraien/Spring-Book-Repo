package com.example.BookProject.Servies;

import java.util.List;

import com.example.BookProject.Model.Book;
import com.example.BookProject.Model.BookDTO;

public interface IBookServies {
	
	////////////////////////////Get Data Base ////////////////////////////
	public List<BookDTO> FindAllBook();
	public BookDTO FindById(Long id);
	
	////////////////////////////Update Data Base ////////////////////////////
	public void AddBook(BookDTO newBook, Long id);
	public void DeleteBook(Long id);
	public void EditBook(BookDTO editBook,long Authid,long Bookid);
	//////////////////////////Opreating DataBase///////////////////////////////
	public int CountBook();
}
