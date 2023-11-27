package com.example.controller;

import com.example.dao.IuserDAO;
import com.example.models.UserC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
public class UserRestController {

	@Autowired
	private IuserDAO userDAO;


	 @GetMapping("/api/user/{id}")
	 public UserC getUser(@PathVariable Long id){
		 UserC userC = new UserC();

		 return userC;
	 }

	@GetMapping("/api/userRegister/{user}")
	public void updateUser(@PathVariable UserC user){
		userDAO.userRegister(user);
	}

	@DeleteMapping("/api/userDelete/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		userDAO.userDelete(id);
	}

	@GetMapping("/api/listUsers")
	public List<UserC> listUsers(){

		return userDAO.listUsers();
	}

}
