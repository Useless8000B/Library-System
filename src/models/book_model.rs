pub struct BookModel {
    name: String,
}

impl BookModel {
    pub fn new(name: &str) -> Self {
        BookModel {
            name: name.to_string(),
        }
    }

    pub fn get_name(&self) -> &str {
        &self.name
    }
}
