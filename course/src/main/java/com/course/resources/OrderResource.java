package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.Order;
import com.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService OrderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll (){
		List<Order> Orders = OrderService.findAll();
		return ResponseEntity.ok().body(Orders);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id){
		Order Order = OrderService.findById(id);
		return ResponseEntity.ok().body(Order);
	}

}
