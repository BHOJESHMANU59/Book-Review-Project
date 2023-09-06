package com.book.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.dao.UserDao;
import com.book.dto.UserDto;
import com.book.entitys.User;
import com.book.service.UserService;
import com.book.util_response.ResponseStructure;
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public ResponseStructure<?> saveUser(User user) 
	{
		User u=new User();
		user.setBooks(u.getBooks());
		user.setReviews(u.getReviews());
		UserDto udto = dao.saveUser(user);
		
		ResponseStructure<UserDto> response=new ResponseStructure<>();
		response.setData(udto);
		response.setHttpStatus(HttpStatus.CREATED);
		response.setMessage("User Data Saved Successfully");
		return response;
	}

	@Override
	public ResponseStructure<?> fetchAll() 
	{
		List<UserDto> all = dao.fetchAll();
		
		ResponseStructure<List<UserDto>> response=new ResponseStructure<>();
		response.setData(all);
		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Data Retrived Successfully");
		return response;
	}

}
