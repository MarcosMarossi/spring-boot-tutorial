package com.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Category;
import com.course.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
