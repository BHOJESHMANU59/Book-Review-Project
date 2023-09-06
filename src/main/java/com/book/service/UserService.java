package com.book.service;


import com.book.entitys.User;
import com.book.util_response.ResponseStructure;

public interface UserService {

   public ResponseStructure<?> saveUser(User user);
   
   public ResponseStructure<?> fetchAll();

}
