package com.useless.library.repositories;

public interface BookRepository {
	void retrieveBooks();
	void createBook(String book_title);
	void deleteBook(String book_title);
}
