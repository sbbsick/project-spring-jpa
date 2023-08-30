package com.exemplonelioalves.cursospring.repository;

import com.exemplonelioalves.cursospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
