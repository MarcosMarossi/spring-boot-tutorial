package com.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll (){
		User u = new User(1, "HST", "(19)9988556677", "hst@hst.com.br", "66");
		return ResponseEntity.ok().body(u);
	}

}
