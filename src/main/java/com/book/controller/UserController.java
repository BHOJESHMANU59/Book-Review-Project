package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("{id}")
	public ResponseEntity<?> findbyId(@PathVariable int id )
	{
		ResponseStructure<?> responseStructure=service.findById(id);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("user/{name}")
	public ResponseEntity<?> findbyName(@PathVariable String name )
	{
		ResponseStructure<?> responseStructure=service.findByName(name);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@PutMapping("{userId}/update")
	public ResponseEntity<?> update(@PathVariable int userId, @RequestBody User user) 
	{
	    ResponseStructure<?> responseStructure = service.update(userId, user);
	    return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	@DeleteMapping("{userId}/delete")
	public ResponseEntity<?> delete(@PathVariable int userId)
	{
		  ResponseStructure<?> responseStructure = service.delete(userId);
		  return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}



}
