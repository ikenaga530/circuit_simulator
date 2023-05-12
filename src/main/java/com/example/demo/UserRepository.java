package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	User findByUsername(@Param("username") String username);
	
	int countByUsername(String username); //追加部分
	
}