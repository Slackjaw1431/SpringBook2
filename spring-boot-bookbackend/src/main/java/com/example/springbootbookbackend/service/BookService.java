package com.example.springbootbookbackend.service;

import java.util.List;
import java.util.Optional;

import com.example.springbootbookbackend.entity.Book;

public interface BookService {
	
	Book saveBook(Book book);
	List<Book> fetchBooks();
	void delete(Book book);
	Book update(Book book);
	Optional<Book> get(Long id);
}
