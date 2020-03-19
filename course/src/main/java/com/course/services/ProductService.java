package com.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Product;
import com.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository ProductRespository;
	
	public List<Product> findAll(){
		return ProductRespository.findAll();
	}
	
	public Product findById(Integer id){
		Optional<Product> Product = ProductRespository.findById(id);
		return Product.get();
	}

}
