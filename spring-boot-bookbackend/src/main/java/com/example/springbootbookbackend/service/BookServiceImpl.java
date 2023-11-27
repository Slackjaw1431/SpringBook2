package com.example.springbootbookbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootbookbackend.entity.Book;
import com.example.springbootbookbackend.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> fetchBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
	}

	@Override
	public Book update(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> get(Long id) {
		if (bookRepository.existsById(id)) {
			return bookRepository.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}



}
