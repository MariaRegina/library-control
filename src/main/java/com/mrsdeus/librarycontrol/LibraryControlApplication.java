package com.mrsdeus.librarycontrol;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mrsdeus.librarycontrol.models.ApplicationUser;
import com.mrsdeus.librarycontrol.models.Role;
import com.mrsdeus.librarycontrol.repositories.ApplicationUserRepository;
import com.mrsdeus.librarycontrol.repositories.RoleRepository;

@SpringBootApplication
public class LibraryControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryControlApplication.class, args);
	}

	@Bean
	  public CommandLineRunner adicionaUser(ApplicationUserRepository applicationUserRepository,
			  	RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
	      return (args) -> {
	      	ApplicationUser applicationUser = new ApplicationUser();
	      	
	      	Set<Role> roles = new HashSet<Role>();
			
			Role admin = new Role("ADMIN");
			Role user = new Role("USER");

			roleRepository.save(admin);
	      	roleRepository.save(user);
			
			roles.add(admin);
			roles.add(user);
	      	
	      	applicationUser.setPassword(passwordEncoder.encode("admin"));
	      	applicationUser.setCreateDate(new Date((new java.util.Date()).getTime()));
	      	applicationUser.setEmail("teste");
	      	applicationUser.setUsername("admin");
	      	applicationUser.setAuthorities(roles);
	      	
	      	applicationUserRepository.save(applicationUser);
	      };
	  }
}
