package com.greenstitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenstitch.entity.signup;

public interface repository extends JpaRepository<signup, Integer>{
	
    boolean existsByEmail(String email);
	
	signup getByEmail(String email);
}
