package com.greenstitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenstitch.entity.signup;
import com.greenstitch.seervices.services;



@Controller
public class controller {
	
	@Autowired
	services service;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String sign() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("id")int id, 
			@RequestParam("name")String name, 
			@RequestParam("email")String email, 
			@RequestParam("password")String password) 
	{
		boolean idExist = service.id(id);
		boolean emailExist=service.checkEmail(email);
		if(!idExist && !emailExist) {
			signup user = new signup();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			service.addUsers(user);

			return "signin";
		}
		else {
			return "signup";
		}
	}
}
	