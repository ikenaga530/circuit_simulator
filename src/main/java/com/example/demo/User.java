package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_student")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	private int userId;
	private String username;
	private String name;
	@JsonIgnore
	private String password;
}