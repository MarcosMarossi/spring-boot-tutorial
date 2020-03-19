package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
