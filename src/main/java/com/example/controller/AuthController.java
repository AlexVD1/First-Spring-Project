package com.example.controller;

import com.example.dao.IuserDAO;
import com.example.models.UserC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private IuserDAO userDAO;
    @PostMapping("/api/login")
    public boolean login(@RequestBody UserC user){
         return  userDAO.checkCredentials(user);
    }
}
