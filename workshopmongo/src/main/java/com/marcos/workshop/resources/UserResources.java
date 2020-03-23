package com.marcos.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.workshop.model.User;
import com.marcos.workshop.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResources {
	
	@Autowired
	private UserService user;
	
	@GetMapping
	public List<User> findAll() {		
		List<User> list = user.findAll();
		return list;		
	}

}
