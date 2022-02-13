package com.kart.ps.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kart.ps.api.enity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
