package com.onsmarttech.invillia.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.onsmarttech.invillia.dao.StoreFilter;
import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.repositories.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository repo;

	public Store create(@Valid Store store) {
		Optional<Store> storeSaved = repo.findByName(store.getName());

		if (storeSaved.isPresent()) {
			throw new DataIntegrityViolationException("Store already exists");
		}

		return repo.saveAndFlush(store);
	}

	public Store update(Integer idStore, @Valid Store store) {
		Optional<Store> storeSaved = repo.findById(idStore);

		if (!storeSaved.isPresent()) {
			throw new DataIntegrityViolationException("Store does not exist");
		}

		return repo.saveAndFlush(store);
	}

	public Store findById(Integer idStore) {
		Optional<Store> storeSaved = repo.findById(idStore);

		return storeSaved.isPresent() ? storeSaved.get() : new Store();
	}

	public List<Store> filter(StoreFilter filter) {
		return repo.filter(filter);
	}

}
