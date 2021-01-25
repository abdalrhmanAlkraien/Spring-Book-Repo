package com.example.BookProject.Servies.AuthorServies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookProject.Model.Book;
import com.example.BookProject.Model.AuthorModel.Author;
import com.example.BookProject.Model.AuthorModel.AuthorDTO;
import com.example.BookProject.Repostory.AuthorRepo.IAuthorRepo;

@Service
public class AuthorServies implements IAuthorServies {

	IAuthorRepo repo;

	@Autowired
	AuthorServies(IAuthorRepo repo) {
		this.repo = repo;
	}

	//////////////////////////// Get Data Base ////////////////////////////
	@Override
	public List<AuthorDTO> getAuthors() {
		// TODO Auto-generated method stub
		List<Author> list = new ArrayList<Author>();
		List<AuthorDTO> toDto = new ArrayList<AuthorDTO>();
		list = repo.findAll();
		for (Author x : list) {
			toDto.add(x.toDto());
		}
		return toDto;
	}

	public AuthorDTO findById(Long id) {
		Author auth = repo.findById(id).get();
		AuthorDTO toDto = auth.toDto();
		return toDto;
	}

	@Override
	public AuthorDTO FindByName(String firstName) {

		Author auth = repo.findByFirstname(firstName).get();

		AuthorDTO toDto = auth.toDto();
		return toDto;
	}

	//////////////////////////// Update Data Base ////////////////////////////

	public void AddAuthor(AuthorDTO dtoAuthor) {
		Author auth = new Author();
		auth = dtoAuthor.toEntity();
		repo.save(auth);
	}

	public void deleteAuthor(Long id) {
		repo.deleteById(id);
	}

	public void EditAuthor(AuthorDTO auth, Long id) {

		if (repo.findById(id).isPresent()) {

			Author author = repo.findById(id).get();
			author.setFirstname(auth.getFirstname());
			author.setLastName(auth.getLastName());
			// author.setBooks(auth.getBooks());
			repo.save(author);

		} else {
			System.out.println("Auth is Null");
		}

	}

	////////////////////////// Opreating DataBase///////////////////////////////
	@Override
	public int CountBook(Long id) {
		Author authors = repo.findById(id).get();

//		Author authors2=new Author();
//		List<Book> book=new ArrayList<Book>(); 
//		book.addAll(authors.getBooks());
		return authors.getBooks().size();
	}

}
