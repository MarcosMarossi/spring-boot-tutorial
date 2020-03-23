package com.marcos.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcos.workshop.model.User;
import com.marcos.workshop.repository.UserRespository;

@Configuration
public class Test implements CommandLineRunner {
	
	@Autowired
	private UserRespository user;

	@Override
	public void run(String... args) throws Exception {
		
		user.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		user.saveAll(Arrays.asList(maria, alex, bob));
	}
}
