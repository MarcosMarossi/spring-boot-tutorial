package com.marcos.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.workshop.model.User;
import com.marcos.workshop.repository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository repoUser;
	
	public List<User> findAll() {
		return repoUser.findAll();
	}

}