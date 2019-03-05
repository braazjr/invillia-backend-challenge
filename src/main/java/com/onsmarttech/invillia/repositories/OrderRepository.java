package com.onsmarttech.invillia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.repositories.order.OrderRepositoryCustom;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, OrderRepositoryCustom {

}
