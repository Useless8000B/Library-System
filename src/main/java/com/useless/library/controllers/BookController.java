package com.useless.library.controllers;

public interface BookController {
	void getBooks();
	void addBook(String book_title);
	void removebook(String book_title);
}
