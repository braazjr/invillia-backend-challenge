package com.onsmarttech.invillia.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsmarttech.invillia.dao.OrderFilter;
import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.entities.enums.OrderStatus;
import com.onsmarttech.invillia.entities.enums.PaymentStatus;
import com.onsmarttech.invillia.repositories.OrderRepository;
import com.onsmarttech.invillia.repositories.StoreRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private StoreRepository storeRepository;

	public Order create(@Valid Order order) throws Exception {
		Optional<Store> store = storeRepository.findById(order.getStore().getId());

		if (!store.isPresent()) {
			throw new Exception("Store not found!");
		}

		order.setStore(store.get());
		return repo.saveAndFlush(order);
	}

	public List<Order> filter(OrderFilter filter) {
		return repo.filter(filter);
	}

	public Order orderRefund(Integer idOrder) throws Exception {
		Optional<Order> orderOptional = repo.findById(idOrder);

		if (!orderOptional.isPresent()) {
			throw new Exception("Order not found!");
		}

		Order order = orderOptional.get();
		order.setStatus(OrderStatus.REFUNDED);

		if (order.getPayment() != null) {
			order.getPayment().setStatus(PaymentStatus.CANCELED);
		}

		return repo.saveAndFlush(order);
	}

}
