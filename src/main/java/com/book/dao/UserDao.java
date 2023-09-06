package com.book.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dto.UserDto;
import com.book.entitys.User;
import com.book.exceptions.UserDetailsNotFoundException;
import com.book.repository.UserRepository;
@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserDto dto;
	
	public UserDto saveUser(User user)
	{
		User u = repo.save(user);
		
		if(u!=null)
		{
			
			dto.setUserId(u.getUserId());
			dto.setUserName(u.getUserName());
			dto.setPhno(u.getPhno());
			dto.setUserMail(u.getUserMail());
			dto.setRole(u.getRole());
			
			return dto;
		}
		throw new UserDetailsNotFoundException("User Data Not Found");
		
	}

	public List<UserDto> fetchAll() 
	{
		List<User> findAll = repo.findAll();
		
		List<UserDto> l=new ArrayList<>();
		
		if(!findAll.isEmpty())
		{
			for (User user : findAll)
			{
				dto.setUserId(user.getUserId());
				dto.setUserName(user.getUserName());
				dto.setUserMail(user.getUserMail());
				dto.setPhno(user.getPhno());
				dto.setRole(user.getRole());
				l.add(dto);
				
			}
			return l;
		}
		throw new UserDetailsNotFoundException("User Data Not Found");
		
		
	}

}
