package com.marcos.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcos.workshop.model.Post;
import com.marcos.workshop.model.User;

@Repository

public interface PostRespository extends MongoRepository<Post, String> {

}
