package com.jin.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jin.security1.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}