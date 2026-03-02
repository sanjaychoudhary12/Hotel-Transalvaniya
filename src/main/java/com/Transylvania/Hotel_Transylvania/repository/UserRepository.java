package com.Transylvania.Hotel_Transylvania.repository;

import com.Transylvania.Hotel_Transylvania.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}