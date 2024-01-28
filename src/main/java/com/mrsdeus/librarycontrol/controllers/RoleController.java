package com.mrsdeus.librarycontrol.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrsdeus.librarycontrol.models.ApplicationUser.Role;
import com.mrsdeus.librarycontrol.services.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	
	@Autowired
	RoleService service;
	
    @PostMapping
    public Role save(@RequestBody Role role){
        return service.save(role);
    }
	
    @GetMapping
    public List<Role> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> findById(UUID id){
        return service.findById(id);
    }
    
    @GetMapping("/{authority}")
    public Role loadUserByUsername(String authority){
        return service.findByAuthority(authority);
    }

    @DeleteMapping("/{id}")
    public void deleteById(UUID id){
    	service.deleteById(id);
    }
}