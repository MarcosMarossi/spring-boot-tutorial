package com.marcos.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.workshop.dto.UserDTO;
import com.marcos.workshop.model.User;
import com.marcos.workshop.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResources {
	
	@Autowired
	private UserService user;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll() {		
		List<User> list = user.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);		
	}

}
