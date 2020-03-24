package com.marcos.workshop.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.workshop.model.Post;
import com.marcos.workshop.repository.PostRespository;
import com.marcos.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRespository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> Post = repo.findById(id);
		return Post.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
	}
	
	public List<Post> findByTitle (String text){
		return repo.searchText(text);
	}
	
	public List<Post> fullSearch (String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
