package com.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.User;
import com.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRespository;
	
	public List<User> findAll(){
		return userRespository.findAll();
	}
	
	public User findById(Integer id){
		Optional<User> user = userRespository.findById(id);
		return user.get();
	}

}
