package com.book.exceptions;

public class BookIdNotFoundException extends RuntimeException
{

	public BookIdNotFoundException(String message) {
		super(message);
	}

}
