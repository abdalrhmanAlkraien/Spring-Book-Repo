package com.example.BookProject.Repostory.AuthorRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.Model.AuthorModel.Author;

@Repository
public interface IAuthorRepo extends JpaRepository<Author, Long>{
	
	Optional<Author> findByFirstname(String firstname);
	
	

}
