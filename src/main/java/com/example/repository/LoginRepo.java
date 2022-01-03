package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserLogin;


@Repository
public interface LoginRepo extends JpaRepository<UserLogin, Integer> {
	
	public List<UserLogin> findByEmail(String email);
}
