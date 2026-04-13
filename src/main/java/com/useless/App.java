package com.useless;

import com.useless.ui.UI;
import com.useless.utils.Format;

public class App {
	public static void main(String[] args) {
		
		boolean running = true;
		int option;
		
		while (running) {
			Format.Line();
			UI.showMenu();
			Format.Line();
			option = UI.getChoice();
			
			switch (option) {
				case 1:
					UI.showBooks();
					break;
				case 2:
					UI.addBook();
					break;
				case 3:
					UI.removeBook();
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
