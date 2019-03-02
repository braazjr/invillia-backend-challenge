package com.onsmarttech.invillia.repositories.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.dao.StoreFilter;
import com.onsmarttech.invillia.entities.Store;

@Repository
public class StoreRepositoryImpl implements StoreRepositoryCustom {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Store> filter(StoreFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Store> query = builder.createQuery(Store.class);

		Root<Store> store = query.from(Store.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (filter.getName() != null) {
			predicates.add(builder.like(store.get("name"), filter.getName()));
		}

		if (filter.getAddress() != null) {
			predicates.add(builder.like(store.get("address"), filter.getAddress()));
		}

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}
}
