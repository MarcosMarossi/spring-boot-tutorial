package com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.model.Category;
import com.course.model.Order;
import com.course.model.OrderItem;
import com.course.model.OrderStatus;
import com.course.model.Payment;
import com.course.model.Product;
import com.course.model.User;
import com.course.repositories.CategoryRepository;
import com.course.repositories.OrderItemRepository;
import com.course.repositories.OrderRepository;
import com.course.repositories.ProductRepository;
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
	
	@Autowired
	CategoryRepository category;
	
	@Autowired
	ProductRepository product;
	
	@Autowired
	OrderItemRepository orderItem;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		category.saveAll(Arrays.asList(cat1, cat2, cat3));
		product.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		product.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		User user1 = new User("Carlos", "(19)9988556677", "carlos@gmail.com", "pass123");
		User user2 = new User("Magdalena", "(19)9988556677", "magdalena@gmail.com", "pass123");
		User user3 = new User("Bianca", "(19)9988556677", "bianca@gmail.com", "pass123");
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.WAITING_PAYMENT); 
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.CANCELED);
		Order o3 = new Order(Instant.parse("2019-07-21T03:42:10Z"), user3, OrderStatus.DELIVERED);
		Order o4 = new Order(Instant.parse("2019-07-14T03:22:10Z"), user3, OrderStatus.PAID);
		
		user.saveAll(Arrays.asList(user1, user2, user3));		
		order.saveAll(Arrays.asList(o1,o2,o3,o4));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItem.saveAll(Arrays.asList(oi1, oi2,oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-07-14T03:22:10Z"), o4 );
		o4.setPayment(pay1);
		
		order.saveAll(Arrays.asList(o1,o2,o3,o4));
	}
}
