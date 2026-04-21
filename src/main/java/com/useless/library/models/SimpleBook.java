package com.useless.library.models;

public class SimpleBook implements Book{
	private final String title;

	public SimpleBook(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
