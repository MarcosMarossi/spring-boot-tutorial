package com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.model.Order;
import com.course.model.User;
import com.course.repositories.OrderRepository;
import com.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	/**
	 * Class seeding. Populating H2 Database. Dependency Injection
	 * CommandLineRunner ~ Thread
	 */
	
	@Autowired
	private UserRepository user;

	@Autowired
	private OrderRepository order;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User("Carlos", "(19)9988556677", "carlos@gmail.com", "pass123");
		User user2 = new User("Magdalena", "(19)9988556677", "magdalena@gmail.com", "pass123");
		User user3 = new User("Bianca", "(19)9988556677", "bianca@gmail.com", "pass123");
		
		
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), user1); 
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), user2);
		Order o3 = new Order(Instant.parse("2019-07-21T03:42:10Z"), user3);
		
		user.saveAll(Arrays.asList(user1, user2, user3));		
		order.saveAll(Arrays.asList(o1,o2,o3));
	}
}
