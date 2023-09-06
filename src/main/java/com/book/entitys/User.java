package com.book.entitys;

import java.util.ArrayList;
import java.util.List;


import com.book.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;
	
	@Column(name="UserName")
	@NotBlank(message = "Customer cannot be blank")
	@NotNull(message = "Customer cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String userName;
	
	@Email(regexp = "[A-Z,a-z]{3,10}[0-9]{2,5}@gmail[.]com",message = "Email Shout be in The Form of @gmail.com")
	private String userMail;
	
	@Min(6000000000l)
	@Max(9999999999l)
	private long phno;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "8 characters mandatory(1 upperCase,1 lowerCase,1 special Character,1 number)")
	private String userPwd;
	
	private UserRole role;
	
	@OneToMany(mappedBy = "user")
	private List<Book> books=new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Review> reviews=new ArrayList<>();
	
	

}
