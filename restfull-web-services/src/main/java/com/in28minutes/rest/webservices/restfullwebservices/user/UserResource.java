package com.in28minutes.rest.webservices.restfullwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ch.qos.logback.classic.net.server.ServerSocketReceiver;

@RestController
public class UserResource {
	
	@Autowired
	UserDaoService userDao ;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userDao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user = userDao.findOne(id);
		if( user == null )
			throw new UserNotFoundException(String.format("User with id '%s' not found",id));
		return user; 
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User newUser = userDao.Save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}").buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();  
	}

	

}
