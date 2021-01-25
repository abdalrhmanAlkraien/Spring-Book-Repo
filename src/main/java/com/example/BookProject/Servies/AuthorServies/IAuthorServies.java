package com.example.BookProject.Servies.AuthorServies;

import java.util.List;

import com.example.BookProject.Model.AuthorModel.Author;
import com.example.BookProject.Model.AuthorModel.AuthorDTO;

public interface IAuthorServies {
	
	
	////////////////////////////Get Data Base ////////////////////////////
	public List<AuthorDTO> getAuthors();
	
	public AuthorDTO FindByName(String firstName);
	
	public AuthorDTO findById(Long id);
	
	

	////////////////////////////Update Data Base ////////////////////////////
	public void AddAuthor(AuthorDTO auther);
	
	public void deleteAuthor(Long id);
	
	public void EditAuthor(AuthorDTO auth,Long id);
	
	//////////////////////////Opreating DataBase///////////////////////////////
	public int  CountBook(Long id);

}
