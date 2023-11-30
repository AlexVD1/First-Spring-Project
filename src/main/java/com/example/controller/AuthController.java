package com.example.controller;

import com.example.dao.IuserDAO;
import com.example.models.UserC;
import com.example.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private IuserDAO userDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/api/login")
    public String login(@RequestBody UserC user){
        UserC loggedUser= userDAO.checkCredentials(user);
        if(loggedUser!=null)
        {
            String tokenJWT = jwtUtil.create(String.valueOf(loggedUser.getId()),loggedUser.getEmail());
            return tokenJWT;
        }

         return "Failed" ;
    }
}
