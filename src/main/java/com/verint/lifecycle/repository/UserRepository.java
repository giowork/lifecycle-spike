package com.verint.lifecycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verint.lifecycle.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
}
