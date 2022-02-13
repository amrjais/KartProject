package com.kart.os.api.common;

import com.kart.os.api.entity.Order;

public class TransactionRespose {

	private Order order;
	private String transactionId;
	private double ammount;
	private String message;

	public TransactionRespose(Order order, String transactionId, double ammount, String message) {
		super();
		this.order = order;
		this.transactionId = transactionId;
		this.ammount = ammount;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

}
