package com.onsmarttech.invillia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.entities.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {

	Optional<Store> findByName(String name);

}
