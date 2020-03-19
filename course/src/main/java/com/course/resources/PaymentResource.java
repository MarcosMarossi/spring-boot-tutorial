package com.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.Payment;
import com.course.services.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll (){
		List<Payment> Payments = paymentService.findAll();
		return ResponseEntity.ok().body(Payments);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Integer id){
		Payment Payment = paymentService.findById(id);
		return ResponseEntity.ok().body(Payment);
	}

}
