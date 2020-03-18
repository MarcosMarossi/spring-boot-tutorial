package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
