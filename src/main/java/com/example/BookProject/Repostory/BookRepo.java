package com.example.BookProject.Repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookProject.Model.Book;
import com.example.BookProject.Model.AuthorModel.Author;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	Optional<Book> findByTitle(String title);
}
