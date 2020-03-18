package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
