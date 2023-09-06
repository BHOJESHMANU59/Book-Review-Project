package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entitys.User;
import com.book.service.UserService;
import com.book.util_response.ResponseStructure;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		ResponseStructure<?> responseStructure=service.saveUser(user);
		
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("/getAlldata")
	public ResponseEntity<?> fetchAll()
	{
		ResponseStructure<?> responseStructure=service.fetchAll();
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}

}
