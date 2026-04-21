package com.useless.library.repositories;

import java.util.ArrayList;
import java.util.List;

import com.useless.library.interfaces.BookRepositoryInterface;
import com.useless.library.models.Book;
import com.useless.library.models.SimpleBook;

public class BookRepository implements BookRepositoryInterface {
	private static final List<Book> books = new ArrayList<>();
	private static BookRepository _instance;

	@Override
	public void retrieveBooks() {
		if (books.isEmpty()) {
			System.out.println("The library is empty.");
		}

		for (Book b : books) {
			System.out.println("-" + b.getTitle());
		}
	}

	@Override
	public void createBook(String book_title) {
		Book new_book = new SimpleBook(book_title);

		books.add(new_book);
	}

	@Override
	public void deleteBook(String bookToRemove) {
		boolean removed = books.removeIf(b -> b.getTitle().equalsIgnoreCase(bookToRemove));

		if (removed) {
			System.out.println("Book removed!");
		} else {
			System.out.println("Book not found!");
		}
	}

	public static synchronized BookRepository getInstance() {
		if (_instance == null) {
			_instance = new BookRepository();
		}

		return _instance;
	}
}
