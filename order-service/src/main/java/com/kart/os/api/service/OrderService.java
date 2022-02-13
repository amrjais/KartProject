package com.kart.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kart.os.api.common.Payment;
import com.kart.os.api.common.TransactionRequest;
import com.kart.os.api.common.TransactionRespose;
import com.kart.os.api.entity.Order;
import com.kart.os.api.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${dopayment}")
	private String PAYMENT_ENDPOINT;
	
	@Autowired
	private Environment env;
	
	
	public TransactionRespose saveOrder(TransactionRequest transactionRequest) {
		PAYMENT_ENDPOINT= env.getProperty("dopayment");
		env.containsProperty("dopayment");
		Order order2 = orderRepository.save(transactionRequest.getOrder());
		String response = "Payment UnSuccessfull";
		Payment payment = new Payment();
		Order order = transactionRequest.getOrder();
		payment.setAmount(order2.getPrice());
		payment.setOrderId(order2.getId());
		Payment paymentResponse = restTemplate.postForObject(PAYMENT_ENDPOINT, payment,
				Payment.class);

		if (paymentResponse.getPaymentStatus().equals("Success")) {
			response = "Successfull payment: Order Placed";
		}
		return new TransactionRespose(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
	}

}
