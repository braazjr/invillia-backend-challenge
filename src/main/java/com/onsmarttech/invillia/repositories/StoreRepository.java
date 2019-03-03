package com.onsmarttech.invillia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.repositories.store.StoreRepositoryCustom;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>, StoreRepositoryCustom {

	Optional<Store> findByName(String name);

}
