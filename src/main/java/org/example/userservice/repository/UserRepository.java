package org.example.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
