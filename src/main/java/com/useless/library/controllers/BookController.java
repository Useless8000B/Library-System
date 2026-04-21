package com.useless.library.controllers;

import com.useless.library.interfaces.BookControllerInterface;
import com.useless.library.interfaces.BookRepositoryInterface;

public class BookController implements BookControllerInterface {
	private static BookController _instance;
	private BookRepositoryInterface _bookRepository;

	private BookController(BookRepositoryInterface bookRepository) {
		this._bookRepository = bookRepository;
	}

	@Override
	public void getBooks() {
		this._bookRepository.retrieveBooks();
	}

	@Override
	public void addBook(String book_title) {
		this._bookRepository.createBook(book_title);
	}

	@Override
	public void removebook(String book_title) {
		this._bookRepository.deleteBook(book_title);
	}

	public static synchronized BookController getInstance(BookRepositoryInterface bookRepository) {
		if(_instance == null) {
			_instance = new BookController(bookRepository);
		}

		return _instance;
	}
}
