package com.mrsdeus.librarycontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrsdeus.librarycontrol.models.ApplicationUser.ApplicationUser;
import com.mrsdeus.librarycontrol.repositories.ApplicationUser.ApplicationUserRepository;

@Service
public class ApplicationUserService implements UserDetailsService {
	@Autowired
	private ApplicationUserRepository repository;
	
	@Override
	public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username) ;
	}
	
	public ApplicationUser save(ApplicationUser user) {
		return repository.save(user);
	}
	
	public Optional<ApplicationUser> findById(UUID id) {
		return repository.findById(id);
	}
	
	public List<ApplicationUser> findAll() {
		return  (List<ApplicationUser>) repository.findAll();
	}
	
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
}
