package com.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Category;
import com.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository CategoryRespository;
	
	public List<Category> findAll(){
		return CategoryRespository.findAll();
	}
	
	public Category findById(Integer id){
		Optional<Category> Category = CategoryRespository.findById(id);
		return Category.get();
	}

}
