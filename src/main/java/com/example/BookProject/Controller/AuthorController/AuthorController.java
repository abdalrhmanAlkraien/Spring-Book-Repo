package com.example.BookProject.Controller.AuthorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookProject.Model.AuthorModel.AuthorDTO;
import com.example.BookProject.Servies.AuthorServies.AuthorServies;

@RestController
@RequestMapping(value = "api/author")
public class AuthorController {

	AuthorServies author;

	@Autowired
	public AuthorController(AuthorServies author) {
		this.author = author;
	}

	///////////////////////////////////////// Get
	///////////////////////////////////////// Data/////////////////////////////////////////////////
	@GetMapping(value = "/getall")
	public List<AuthorDTO> getall() {
		return author.getAuthors();
	}

	@GetMapping("/find/{id}")
	public AuthorDTO findById(@PathVariable Long id) {
		return author.findById(id);
	}

	@GetMapping("/findByName/{firstName}")
	public AuthorDTO FindByName(@PathVariable String firstName) {
		return author.FindByName(firstName);
	}

	//////////////////////////////////////// Update Data Base
	//////////////////////////////////////// ////////////////////////////////////////

	@PostMapping("/addNew")
	public void addNew(@RequestBody AuthorDTO dtoAuth) {
		author.AddAuthor(dtoAuth);
		getall();
	}

	@DeleteMapping("/delete/{id}")
	public void DeleteById(@PathVariable Long id) {

		author.deleteAuthor(id);

	}

	@PostMapping("/Edit/{id}")
	public void EditById(@RequestBody AuthorDTO auth, @PathVariable Long id) {
		author.EditAuthor(auth, id);
	}

	////////////////////////// Opreating DataBase///////////////////////////////
	@GetMapping(value = "/getCount/{id}")
	public int getCount(@PathVariable Long id) {

		return author.CountBook(id);
	}
}
