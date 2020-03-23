package com.marcos.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.workshop.model.User;

@RestController
@RequestMapping (value = "/users")
public class UserResources {
	
	@GetMapping
	public List<User> findAll() {
		User user1 = new User(1, "Marcos", "marcos@spring.com");
		User user2 = new User(2, "Alex Green", "alex@spring.com");
		User user3 = new User(3, "Carlos Red", "carlos@spring.com");
		
		List<User> list = new ArrayList<User>();		
		list.addAll(Arrays.asList(user1, user2, user3));
		
		return list;		
	}

}
