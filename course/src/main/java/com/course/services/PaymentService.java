package com.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Payment;
import com.course.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRespository;
	
	public List<Payment> findAll(){
		return paymentRespository.findAll();
	}
	
	public Payment findById(Integer id){
		Optional<Payment> Payment = paymentRespository.findById(id);
		return Payment.get();
	}

}
