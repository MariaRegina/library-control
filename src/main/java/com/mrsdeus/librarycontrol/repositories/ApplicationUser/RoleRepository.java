package com.mrsdeus.librarycontrol.repositories.ApplicationUser;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mrsdeus.librarycontrol.models.ApplicationUser.Role;
import com.mrsdeus.librarycontrol.repositories.BaseRepository;

@Repository
public interface RoleRepository extends BaseRepository<Role, UUID>{
	public Role findByAuthority(String authority);
}
