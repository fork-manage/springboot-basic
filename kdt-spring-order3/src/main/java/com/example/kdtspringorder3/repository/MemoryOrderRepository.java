package com.example.kdtspringorder3.repository;


import com.example.kdtspringorder3.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryOrderRepository implements OrderRepository {
  private final Map<UUID, Order> storage = new ConcurrentHashMap<>();

  @Override
  public Order insert(Order order) {
    storage.put(order.getOrderId(), order);
	return order;
  }
}
