package com.g1.authorizationserver.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;


import java.time.OffsetDateTime;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Type type;
	@CreatedDate
	private OffsetDateTime createdAt;

	public UserEntity() {
	}

	public UserEntity(String name, String email, String password, Type type) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {
		ADMIN, CLIENT;
	}
}
