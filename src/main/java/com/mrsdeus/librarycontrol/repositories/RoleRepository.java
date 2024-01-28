package com.mrsdeus.librarycontrol.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrsdeus.librarycontrol.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, UUID>{
}
