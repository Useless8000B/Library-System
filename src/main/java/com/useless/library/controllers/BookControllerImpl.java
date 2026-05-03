package com.useless.library.controllers;

import com.useless.library.repositories.BookRepository;

public class BookControllerImpl implements BookController {
	private static BookControllerImpl _instance;
	private BookRepository _bookRepository;

	private BookControllerImpl(BookRepository bookRepository) {
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

	public static synchronized BookControllerImpl getInstance(BookRepository bookRepository) {
		if(_instance == null) {
			_instance = new BookControllerImpl(bookRepository);
		}

		return _instance;
	}
}
