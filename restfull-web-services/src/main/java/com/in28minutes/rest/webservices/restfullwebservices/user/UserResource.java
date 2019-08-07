package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDao;

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id) {
        User user = userDao.findOne(id);
        if (user == null)
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));
        return user;
    }

	@DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDao.findOne(id);
        if (user == null)
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));
		User user2 = userDao.deleteById(id);
     }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User newUser = userDao.Save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
