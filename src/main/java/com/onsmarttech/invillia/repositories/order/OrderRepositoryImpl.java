package com.onsmarttech.invillia.repositories.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.dao.OrderFilter;
import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.entities.Store;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Order> filter(OrderFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);

		Root<Order> order = query.from(Order.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (filter.getStatus() != null) {
			predicates.add(builder.equal(order.get("status"), filter.getStatus().toString()));
		}

		if (filter.getStoreId() != null) {
			Join<Order, Store> store = order.join("store");
			predicates.add(builder.equal(store.get("id"), filter.getStoreId()));
		}

		if (filter.getConfirmationDateInitial() != null) {
			predicates.add(builder.greaterThanOrEqualTo(order.get("confirmationDate"), filter.getConfirmationDateInitial()));
		}

		if (filter.getConfirmationDateFinal() != null) {
			predicates.add(builder.lessThanOrEqualTo(order.get("confirmationDate"), filter.getConfirmationDateFinal()));
		}

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}
}
