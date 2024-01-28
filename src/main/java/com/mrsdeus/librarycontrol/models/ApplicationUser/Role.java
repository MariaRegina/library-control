package com.mrsdeus.librarycontrol.models.ApplicationUser;

import java.sql.Date;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import com.mrsdeus.librarycontrol.models.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private String authority;
	
	@Embedded
	private BaseModel baseModel;
	
	public Role() {}
	
	public Role(String authority) {
		this.authority = authority;
	}
	
	public Role(String authority, Date createdAt) {
		this(authority);
		this.setBaseModel(new BaseModel(createdAt));
	}

	public UUID getId() {
		return id;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public BaseModel getBaseModel() {
		return baseModel;
	}

	public void setBaseModel(BaseModel baseModel) {
		this.baseModel = baseModel;
	}
	
}
