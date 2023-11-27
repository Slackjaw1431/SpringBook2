package com.example.springbootbookbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootbookbackend.entity.Book;
import com.example.springbootbookbackend.repository.BookRepository;
import com.example.springbootbookbackend.service.BookService;

@CrossOrigin
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository br;

	@PostMapping("/books")
	public Book addBook(@Validated @RequestBody Book book) {
		return bookService.saveBook(book);
//		return br.save(book);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
//		return br.findAll();
		return bookService.fetchBooks();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
		Optional<Book> b = br.findById(id);
		return ResponseEntity.ok(b);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
		Optional<Book> ob = br.findById(id);

		Book b = ob.get();

		b.setBookTitle(book.getBookTitle());
		b.setAuthor(book.getAuthor());
		b.setCategory(book.getCategory());
		b.setBookPrice(book.getBookPrice());
		b.setQuantity(book.getQuantity());

		Book updatedBook = br.save(b);

		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		Optional<Book> b = bookService.get(id);
		bookService.delete(b.get());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
