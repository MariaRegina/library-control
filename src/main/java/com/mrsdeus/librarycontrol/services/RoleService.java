package com.mrsdeus.librarycontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsdeus.librarycontrol.models.ApplicationUser.Role;
import com.mrsdeus.librarycontrol.repositories.ApplicationUser.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public Role findByAuthority(String authority) {
		return repository.findByAuthority(authority) ;
	}
	
	public Role save(Role role) {
		return repository.save(role);
	}
	
	public Optional<Role> findById(UUID id) {
		return repository.findById(id);
	}
	
	public List<Role> findAll() {
		return  (List<Role>) repository.findAll();
	}
	
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
}
