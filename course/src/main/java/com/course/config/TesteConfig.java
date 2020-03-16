package com.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.model.User;
import com.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	/**
	 * Class seeding. Populating H2 Database. Dependency Injected
	 * CommandLineRunner ~ Thread
	 */
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Carlos", "(19)9988556677", "carlos@gmail.com", "pass123");
		User user2 = new User("Magdalena", "(19)9988556677", "magdalena@gmail.com", "pass123");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}
}
