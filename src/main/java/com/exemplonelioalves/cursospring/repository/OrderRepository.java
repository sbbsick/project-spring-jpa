package com.exemplonelioalves.cursospring.repository;

import com.exemplonelioalves.cursospring.entities.Order;
import com.exemplonelioalves.cursospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
