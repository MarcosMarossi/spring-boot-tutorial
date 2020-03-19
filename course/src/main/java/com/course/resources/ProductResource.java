package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.Product;
import com.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll (){
		List<Product> Products = productService.findAll();
		return ResponseEntity.ok().body(Products);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product Product = productService.findById(id);
		return ResponseEntity.ok().body(Product);
	}

}
