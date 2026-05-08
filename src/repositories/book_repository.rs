use crate::models::book_model::BookModel;

pub struct BookRepository {
    people: Vec<BookModel>,
}

impl BookRepository {
    pub fn new() -> Self {
        BookRepository { people: Vec::new() }
    }

    pub fn retrieve_books(&self) -> &Vec<BookModel> {
        &self.people
    }

    pub fn create_book(&mut self, book_model: BookModel) {
        self.people.push(book_model);
    }

    pub fn remove_book(&mut self, book_name: &str) {
        self.people.retain(|b| b.get_name() != book_name);
    }
}
