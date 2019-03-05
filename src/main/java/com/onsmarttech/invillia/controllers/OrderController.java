package com.onsmarttech.invillia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onsmarttech.invillia.dao.OrderFilter;
import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Order order) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.create(order));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/filter")
	public ResponseEntity<List<Order>> filter(OrderFilter filter) {
		return ResponseEntity.ok(service.filter(filter));
	}
}
