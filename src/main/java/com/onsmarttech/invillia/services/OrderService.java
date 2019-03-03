package com.onsmarttech.invillia.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.entities.Store;
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

}
