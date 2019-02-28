package com.onsmarttech.invillia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.services.StoreService;

@RestController
@RequestMapping(value = "/stores")
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping
	@ResponseBody
	public String index() {
		return "teste";
	}

	@PostMapping
	public ResponseEntity<Store> create(@RequestBody @Valid Store store) {
		return ResponseEntity.ok(service.create(store));
	}
}
