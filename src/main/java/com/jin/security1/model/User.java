package com.jin.security1.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	@CreationTimestamp
	private Timestamp createTime;
	private String provider;//구글
	private String providerId;//구글아이디
	@Builder
	public User(int id, String username, String password, String email, String role, Timestamp createTime,
			String provider, String providerId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.createTime = createTime;
		this.provider = provider;
		this.providerId = providerId;
	}
	
	
}
