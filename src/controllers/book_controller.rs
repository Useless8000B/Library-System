use crate::repositories::book_repository::BookRepository;
use crate::models::book_model::BookModel;

pub struct BookController {
    book_repository: BookRepository,
}

impl BookController {
    pub fn new(book_repository: BookRepository) -> Self {
        BookController {
            book_repository: book_repository,
        }
    }

	pub fn get_books(&self) {
		let books = self.book_repository.retrieve_books();

		if books.is_empty() {
			println!("The library is empty");
		}

		for book in books {
			println!("- {}", book.get_name());
		}
	}

	pub fn add_book(&mut self, name: &str) {
		let book = BookModel::new(name);
		self.book_repository.create_book(book);
		println!("Book added!");
	}

	pub fn remove_book(&mut self, name: &str) {
		self.book_repository.remove_book(name);
		println!("Book removed!")
	}
}
