package com.kyrie.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kyrie.security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
