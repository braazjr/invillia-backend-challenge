package com.onsmarttech.invillia.repositories.order;

import java.util.List;

import com.onsmarttech.invillia.dao.OrderFilter;
import com.onsmarttech.invillia.entities.Order;

public interface OrderRepositoryCustom {

	List<Order> filter(OrderFilter filter);
}
