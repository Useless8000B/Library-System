#[derive(Debug)]
pub enum Menu {
    Check,
    Add,
    Remove,
    Exit,
}

impl Menu {
    pub fn as_string(&self) -> &str {
		match self {
			Menu::Check => "[1] Check books",
            Menu::Add => "[2] Add book",
            Menu::Remove => "[3] Remove book",
            Menu::Exit => "[4] Check books",
		}
	}

	pub fn from_input(choice: u8) -> Option<Self> {
		match choice {
			1 => Some(Menu::Check),
			2 => Some(Menu::Add),
			3 => Some(Menu::Remove),
			4 => Some(Menu::Exit),
			_ => None
		}
	}

	pub fn all() -> [Menu; 4] {
		[Menu::Check, Menu::Add, Menu::Remove, Menu::Exit]
	}
}
