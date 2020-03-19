package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
