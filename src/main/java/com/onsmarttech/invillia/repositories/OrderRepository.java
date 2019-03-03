package com.onsmarttech.invillia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
