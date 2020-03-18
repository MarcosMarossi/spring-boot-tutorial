package com.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Order;
import com.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository OrderRespository;
	
	public List<Order> findAll(){
		return OrderRespository.findAll();
	}
	
	public Order findById(Integer id){
		Optional<Order> Order = OrderRespository.findById(id);
		return Order.get();
	}

}
