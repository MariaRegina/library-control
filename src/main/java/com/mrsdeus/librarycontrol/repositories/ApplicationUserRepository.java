package com.mrsdeus.librarycontrol.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrsdeus.librarycontrol.models.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, UUID>{
	public ApplicationUser findByUsername(String username);
}
