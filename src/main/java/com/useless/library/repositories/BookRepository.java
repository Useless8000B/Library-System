package com.useless.library.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.useless.library.interfaces.BookRepositoryInterface;
import com.useless.library.models.Book;
import com.useless.library.models.SimpleBook;

public class BookRepository implements BookRepositoryInterface {
	private static final List<Book> books = new ArrayList<>();
	private final Path filePath = Paths.get("books.csv");
	private static BookRepository _instance;

	private BookRepository() {
		loadFromFile();
	}

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
		saveToFile();
	}

	@Override
	public void deleteBook(String bookToRemove) {
		boolean removed = books.removeIf(b -> b.getTitle().equalsIgnoreCase(bookToRemove));

		if (removed) {
			System.out.println("Book removed!");
			saveToFile();
		} else {
			System.out.println("Book not found!");
		}
	}

	private void saveToFile() {
		try {
			List<String> lines = books.stream().map(Book::getTitle).collect(Collectors.toList());
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.err.println("Error saving to file: " + e.getMessage());
		}
	}

	private void loadFromFile() {
		if (!Files.exists(filePath))
			return;

		try {
			List<String> lines = Files.readAllLines(filePath);

			for (String line : lines) {
				if(!line.isBlank()) {
					books.add(new SimpleBook(line));
				}
			}
		} catch (IOException e) {
			System.err.println("Error loading data: " + e.getMessage());
		}
	}

	public static synchronized BookRepository getInstance() {
		if (_instance == null) {
			_instance = new BookRepository();
		}

		return _instance;
	}
}
