package com.onsmarttech.invillia.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.repositories.StoreRepo;

@Service
public class StoreService {

	@Autowired
	private StoreRepo repo;

	public Store create(@Valid Store store) {
		Optional<Store> storeSaved = repo.findByName(store.getName());

		if (storeSaved.isPresent()) {
			throw new DataIntegrityViolationException("Store already exists");
		}

		return repo.saveAndFlush(store);
	}

}
