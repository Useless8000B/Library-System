package com.useless.library.ui;

import java.util.Scanner;

import com.useless.library.interfaces.UiInterface;

public class UI implements UiInterface {
	private static Scanner input = new Scanner(System.in);
	private static UI _instance;

	private UI() {}

	@Override
	public void showMenu() {
		final String MENU_OPTIONS[] = { "[1] See all books", "[2] Add a book", "[3] Remove a book", "[4] Exit" };

		for (String menu_option : MENU_OPTIONS) {
			System.out.println(menu_option);
		}
	}

	@Override
	public int getChoice() {
		String rawInput = "";
		int choice = -1;

		while (choice == -1) {
			System.out.print("Option: ");
			rawInput = input.nextLine();

			try {
				choice = Integer.parseInt(rawInput.trim());

				if (choice < 1 || choice > 4) {
					System.out.println("Invalid option! Please choose between 1 and 4.");
					choice = -1;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Please enter a valid number.");
				choice = -1;
			}
		}

		return choice;
	}

	@Override
	public String getBookName() {
		String name = "";

		while (name.trim().isEmpty()) {
			System.out.print("Book name: ");
			name = input.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Book name can't be empty!");
			}
		}
		return name;
	}

	public static synchronized UI getInstance() {
		if (_instance == null) {
			_instance = new UI();
		}

		return _instance;
	}
}
