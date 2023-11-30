package com.example.controller;

import com.example.dao.IuserDAO;
import com.example.models.UserC;
import com.example.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
public class UserRestController {

	@Autowired
	private IuserDAO userDAO;

	@Autowired
	private JWTUtil jwtUtil;

	public boolean validarToken(String token){
		String userID=jwtUtil.getKey(token);
		return userID != null;
	}

	 @GetMapping("/api/user/{id}")
	 public UserC getUser(@PathVariable Long id,@RequestHeader(value = "Authorization") String token){
		 if (!validarToken(token)){
			 return null;
		 }
		 return userDAO.getUser(id);
	 }

	@PostMapping("/api/userRegister")
	public void userRegister(@RequestBody UserC user){
		Argon2 arg2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

		String hpassword= arg2.hash(2,1024,2,user.getPassword());
		user.setPassword(hpassword);

		userDAO.userRegister(user);
	}

	@DeleteMapping("/api/userDelete/{id}")
	public void deleteUser(@PathVariable Long id,@RequestHeader(value = "Authorization") String token)
	{
		if (!validarToken(token)){
			return;
		}
		userDAO.userDelete(id);
	}

	@GetMapping("/api/listUsers")
	public List<UserC> listUsers(@RequestHeader(value = "Authorization") String token){
		if (!validarToken(token)){
			return null;
		}
		log.info("mensaje "+ validarToken((token)));
		return userDAO.listUsers();
	}

}
