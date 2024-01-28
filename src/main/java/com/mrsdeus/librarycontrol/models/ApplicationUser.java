package com.mrsdeus.librarycontrol.models;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ApplicationUser implements UserDetails{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Date createDate;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column
    private Integer statusAccount;
    
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//    		name="roles",
//    		)
    private Set<Role> authorities;

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		if(this.role.equals("ADMIN"))
//			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		return this.authorities;
	}
    
    public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

//	public Integer getStatusAccount() {
//		return statusAccount;
//	}
//
//	public void setStatusAccount(Integer statusAccount) {
//		this.statusAccount = statusAccount;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
