package com.marcos.workshop.repository;

import java.util.Date;
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
	
	/**
	 * 
	 * @param text
	 * @param minDate
	 * @param maxDate
	 * 
	 */
	
	@Query("{ $and: [ {date: {$gte: ?1} } , { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'title': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch (String text, Date minDate, Date maxDate);
	

}
