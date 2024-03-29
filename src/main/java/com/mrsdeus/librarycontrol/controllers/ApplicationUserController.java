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

import com.mrsdeus.librarycontrol.models.ApplicationUser.ApplicationUser;
import com.mrsdeus.librarycontrol.services.ApplicationUserService;

@RestController
@RequestMapping("/api/v1/user")
public class ApplicationUserController {
	
	@Autowired
	ApplicationUserService service;
	
    @PostMapping
    public ApplicationUser save(@RequestBody ApplicationUser user){
        return service.save(user);
    }
	
    @GetMapping
    public List<ApplicationUser> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ApplicationUser> findById(UUID id){
        return service.findById(id);
    }
    
    @GetMapping("/{username}")
    public ApplicationUser loadUserByUsername(String username){
        return service.loadUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteById(UUID id){
    	service.deleteById(id);
    }
}
