package com.kart.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kart.os.api.common.TransactionRequest;
import com.kart.os.api.common.TransactionRespose;
import com.kart.os.api.service.OrderService;

/**
 * @author amrjais
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	@Lazy
	private OrderService orderService;

	@PostMapping("/addOrder")
	public TransactionRespose postOrder(@RequestBody TransactionRequest transactionRequest) {
		return orderService.saveOrder(transactionRequest);
	}

}
