package com.exemplonelioalves.cursospring.repository;

import com.exemplonelioalves.cursospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
