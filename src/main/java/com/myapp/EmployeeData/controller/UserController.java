package com.myapp.EmployeeData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.EmployeeData.entity.User;
import com.myapp.EmployeeData.repository.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("users")
    public List<User> alluser(){
    	return repo.findAll();
    }
}
