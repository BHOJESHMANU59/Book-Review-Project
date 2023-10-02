package com.book.service;


import com.book.entitys.User;
import com.book.util_response.ResponseStructure;

public interface UserService {

   public ResponseStructure<?> saveUser(User user);
   
   public ResponseStructure<?> fetchAll();

   public ResponseStructure<?> findById(int id);

   public ResponseStructure<?> findByName(String name);

   public ResponseStructure<?> update(int id, User user);

public ResponseStructure<?> delete(int userId);

}
