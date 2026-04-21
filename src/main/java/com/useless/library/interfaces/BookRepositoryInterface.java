package com.useless.library.interfaces;

public interface BookRepositoryInterface {
	void retrieveBooks();
	void createBook(String book_title);
	void deleteBook(String bookToRemove);
}
