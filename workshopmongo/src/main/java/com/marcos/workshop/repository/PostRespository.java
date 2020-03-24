package com.marcos.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcos.workshop.model.Post;
import com.marcos.workshop.model.User;

@Repository

public interface PostRespository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchText (String text);
	
	List<Post> findByTitleContainingIgnoreCase (String text);
	

}
