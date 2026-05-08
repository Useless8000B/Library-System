use crate::controllers::book_controller::BookController;
use crate::repositories::book_repository::BookRepository;
use crate::view::menu::Menu;

mod controllers;
mod models;
mod repositories;
mod view;
mod utils;

fn main() {
    let book_repository = BookRepository::new();
    let mut book_controller = BookController::new(book_repository);

    loop {
        utils::format::line("-=", 16);
        view::ui::show_menu();
        utils::format::line("-=", 16);
        let choice = view::ui::get_choice();

        match Menu::from_input(choice) {
            Some(Menu::Check) => book_controller.get_books(),
            Some(Menu::Add) => {
                let name = view::ui::get_name();
                book_controller.add_book(&name);
            },
            Some(Menu::Remove) => {
                let name = view::ui::get_name();
                book_controller.remove_book(&name);
            },

            Some(Menu::Exit) => break,

            Option::None => println!("Not an option!")
        }
    }
}
