package com.example.erp_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp_management_system.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
