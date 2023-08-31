package com.exemplonelioalves.cursospring.repository;

import com.exemplonelioalves.cursospring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
