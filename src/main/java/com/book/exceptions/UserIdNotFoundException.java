package com.book.exceptions;

public class UserIdNotFoundException  extends RuntimeException
{

	public UserIdNotFoundException(String message) {
		super(message);
	}

}
