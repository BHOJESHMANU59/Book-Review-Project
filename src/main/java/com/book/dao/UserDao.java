package com.book.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dto.UserDto;
import com.book.entitys.User;
import com.book.exceptions.UserDetailsNotFoundException;
import com.book.exceptions.UserIdNotFoundException;
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

	public UserDto findbyId(int id) 
	{
		Optional<User> user = repo.findById(id);
		if(user.isPresent())
		{
			User u = user.get();
			dto.setUserId(u.getUserId());
			dto.setUserName(u.getUserName());
			dto.setUserMail(u.getUserMail());
			dto.setPhno(u.getPhno());
			dto.setRole(u.getRole());
			
			return dto;
			
		}
		throw new UserIdNotFoundException("Invalid User Id");
		
	}

	public UserDto findbyName(String name) 
	{
		User user = repo.findByUserName(name);
		if(user!=null)
		{
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setUserMail(user.getUserMail());
			dto.setPhno(user.getPhno());
			dto.setRole(user.getRole());
			
			return dto;
			
		}
		throw new UserDetailsNotFoundException("User Not Found");
		
	}

	public UserDto update(int id, User user) 
	{
		Optional<User> usr = repo.findById(id);
		if(usr.isPresent())
		{
			User u = usr.get();
			
			u.setUserName(user.getUserName());
			u.setUserMail(user.getUserMail());
			u.setPhno(user.getPhno());
			u.setUserPwd(user.getUserPwd());
			u.setRole(user.getRole());
			
			repo.save(u);

			dto.setUserId(u.getUserId());
			dto.setUserName(u.getUserName());
			dto.setPhno(u.getPhno());
			dto.setUserMail(u.getUserMail());
			dto.setRole(u.getRole());
			return dto;
		}
		throw new UserIdNotFoundException("User Details Not Found ");
		
	}

	public String delete(int userId) 
	{
		Optional<User> user = repo.findById(userId);
		if(user.isPresent())
		{
			repo.delete(user.get());
			return "User Data Deleted Successfully "+user.get().getUserId();
			
		}
		throw new UserIdNotFoundException("User Id Not Found");
		
	}

}
