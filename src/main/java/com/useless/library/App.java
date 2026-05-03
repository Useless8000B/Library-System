package com.useless.library;

import com.useless.library.controllers.BookController;
import com.useless.library.controllers.BookControllerImpl;
import com.useless.library.repositories.BookRepository;
import com.useless.library.repositories.BookRepositoryImpl;
import com.useless.library.ui.Ui;
import com.useless.library.ui.UiImpl;
import com.useless.library.utils.Format;

public class App {
	private static boolean running = true;
	private static int option;
	private static Ui _UI = UiImpl.getInstance();
	private static BookRepository _bookRepository = BookRepositoryImpl.getInstance();
	private static BookController _bookController = BookControllerImpl.getInstance(_bookRepository);

	public static void main(String[] args) {

		while (running) {
			Format.Line();
			_UI.showMenu();
			Format.Line();
			option = _UI.getChoice();

			switch (option) {
				case 1:
					_bookController.getBooks();
					break;
				case 2:
					String book_name = _UI.getBookName();
					_bookController.addBook(book_name);
					break;
				case 3:
					String book_to_remove = _UI.getBookName();
					_bookController.removebook(book_to_remove);
					break;
				case 4:
					running = false;
					break;
				default:
					System.out.println("Not an option!");
					break;
			}
		}
	}
}
