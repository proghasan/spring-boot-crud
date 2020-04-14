package com.nextprogrammers.crudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextprogrammers.crudApp.model.Book;
import com.nextprogrammers.crudApp.repository.BookRepository;

@Transactional
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> bookList(){
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getBook(long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public String deleteBook(long id) {
		bookRepository.deleteById(id);
		return "Book was reomve";
	}

	public Book updateBook(Book book) {
		Book existBook = bookRepository.findById(book.getId()).orElse(null);
		existBook.setName(book.getName());
		existBook.setAuthor(book.getAuthor());
		existBook.setPrice(book.getPrice());
		
		return bookRepository.save(existBook);
	}
}
