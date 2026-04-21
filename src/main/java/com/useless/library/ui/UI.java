package com.useless.library.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.useless.library.models.Book;
import com.useless.library.models.SimpleBook;

public class UI {
	private static final Scanner input = new Scanner(System.in);
	private static final List<Book> books= new ArrayList<>();

	public static void showMenu() {
		final String MENU_OPTIONS[] = {"[1] See all books", "[2] Add a book", "[3] Remove a book", "[4] Exit"};
		
		for (String menu_option: MENU_OPTIONS) {
			System.out.println(menu_option);
		}
	}

	public static void showBooks() {
		if (books.isEmpty()) {
			System.out.println("The library is empty.");
		}

		for (Book b: books) {
			System.out.println("-" + b.getTitle());
		}
	}

	public static void addBook() {
		System.out.print("Book title: ");
		String book_title = input.nextLine();

		Book new_book = new SimpleBook(book_title);

		books.add(new_book);
	}

	public static void removeBook() {
		System.out.print("Book title: ");
		String bookToRemove = input.nextLine();

		boolean removed = books.removeIf(b -> b.getTitle().equalsIgnoreCase(bookToRemove));

		if (removed) {
			System.out.println("Book removed!");
		} else {
			System.out.println("Book not found!");
		}
	}
	
	public static int getChoice() {
		System.out.print("Option: ");
		while (!input.hasNextInt()) {
			input.next();
		}
		int choice = input.nextInt();
		input.nextLine();
		return choice;
	}
}
