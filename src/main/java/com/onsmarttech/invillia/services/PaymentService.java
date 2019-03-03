package com.onsmarttech.invillia.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.entities.Payment;
import com.onsmarttech.invillia.repositories.OrderRepository;
import com.onsmarttech.invillia.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Autowired
	private OrderRepository orderRepository;

	public Payment pay(@Valid Payment payment) throws Exception {
		Optional<Order> order = orderRepository.findById(payment.getOrder().getId());

		if (!order.isPresent()) {
			throw new Exception("Order is already paid!");
		}

		payment.setOrder(order.get());
		return repo.saveAndFlush(payment);
	}

}
