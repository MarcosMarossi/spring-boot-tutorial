package com.marcos.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.workshop.model.User;
import com.marcos.workshop.repository.UserRespository;
import com.marcos.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRespository repoUser;
	
	public List<User> findAll() {
		return repoUser.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repoUser.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
	}

}
