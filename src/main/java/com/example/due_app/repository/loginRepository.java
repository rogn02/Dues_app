package com.example.due_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.due_app.model.logins;

public interface loginRepository extends JpaRepository<logins, Long>{
	logins findByUsername(@Param("username") String username);
}
