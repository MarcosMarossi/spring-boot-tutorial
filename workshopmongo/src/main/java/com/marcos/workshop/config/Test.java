package com.marcos.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcos.workshop.dto.AuthorDTO;
import com.marcos.workshop.model.Post;
import com.marcos.workshop.model.User;
import com.marcos.workshop.repository.PostRespository;
import com.marcos.workshop.repository.UserRespository;

@Configuration
public class Test implements CommandLineRunner {
	
	@Autowired
	private UserRespository user;
	
	@Autowired
	private PostRespository post;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		user.deleteAll();
		post.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		user.saveAll(Arrays.asList(maria, alex, bob));
				
		Post post1 =  new Post(null, sdf.parse("21/03/2020"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 =  new Post(null, sdf.parse("19/03/2020"), "Vai viajar?", "Queria saber isso, pois combinamos de irmos juntos", new AuthorDTO(alex));
		Post post3 =  new Post(null, sdf.parse("22/03/2020"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(bob));
				
		post.saveAll(Arrays.asList(post1,post2,post3));
		
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		user.save(maria);
	}
}
