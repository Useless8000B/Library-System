use crate::view::menu::Menu;

pub fn show_menu() {
	for option in Menu::all() {
		println!("{}", option.as_string());
	}
}

pub fn get_choice() -> u8 {
	let mut choice = String::new();

	println!("Enter the option: ");

	std::io::stdin()
		.read_line(&mut choice)
		.expect("Error reading choice");

	let choice: u8 = choice.trim().parse().expect("Not a number!");

	choice
}

pub fn get_name() -> String {
	println!("Enter the book name: ");

	let mut name = String::new();

	std::io::stdin()
		.read_line(&mut name)
		.expect("Error reading choice");

	name
}