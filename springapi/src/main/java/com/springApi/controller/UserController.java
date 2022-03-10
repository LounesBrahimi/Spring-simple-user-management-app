package com.springApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springApi.model.User;
import com.springApi.serivice.UserService;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter;
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
}
