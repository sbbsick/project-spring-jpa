package com.exemplonelioalves.cursospring.repository;

import com.exemplonelioalves.cursospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
