package com.useless.library;

import com.useless.library.controllers.BookController;
import com.useless.library.interfaces.BookControllerInterface;
import com.useless.library.interfaces.BookRepositoryInterface;
import com.useless.library.interfaces.UiInterface;
import com.useless.library.repositories.BookRepository;
import com.useless.library.ui.UI;
import com.useless.library.utils.Format;

public class App {
	private static boolean running = true;
	private static int option;
	private static UiInterface _UI = UI.getInstance();
	private static BookRepositoryInterface _bookRepository = BookRepository.getInstance();
	private static BookControllerInterface _bookController = BookController.getInstance(_bookRepository);

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
