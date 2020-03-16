package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
