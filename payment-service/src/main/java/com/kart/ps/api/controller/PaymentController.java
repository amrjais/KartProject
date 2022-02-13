/**
 * 
 */
package com.kart.ps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kart.ps.api.enity.Payment;
import com.kart.ps.api.service.PaymentService;

/**
 * @author amrja
 *
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

	@Value("${dopayment}")
	private String PAYMENT_ENDPOINT;
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment postPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
	}
	
	@GetMapping("/{orderId}")
	public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
		return paymentService.findPaymentHistoryByOrderId(orderId);
	}
}

