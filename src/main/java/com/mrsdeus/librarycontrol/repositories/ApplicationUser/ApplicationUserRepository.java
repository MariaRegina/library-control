package com.mrsdeus.librarycontrol.repositories.ApplicationUser;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mrsdeus.librarycontrol.models.ApplicationUser.ApplicationUser;
import com.mrsdeus.librarycontrol.repositories.BaseRepository;

@Repository
public interface ApplicationUserRepository extends BaseRepository<ApplicationUser, UUID>{
	public ApplicationUser findByUsername(String username);
}
