package com.book.dto;


import org.springframework.stereotype.Component;

import com.book.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
@Component
public class UserDto {
	
	private int userId;
	
	@NotBlank(message = "Customer cannot be blank")
	@NotNull(message = "Customer cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String userName;
	
	@Email(regexp = "[A-Z,a-z]{3,10}[0-9]{2,5}@gmail[.]com",message = "Email Shout be in The Form of @gmail.com")
	private String userMail;
	
	@Min(6000000000l)
	@Max(9999999999l)
	private long phno;
	
	private UserRole role;
	
	

}
