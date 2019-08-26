package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceChainRegistration;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @GetMapping("/jpausers")
    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpausers/{id}")
    public Resource<User> retriveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user .isPresent())
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));

        Resource<User> resource = new Resource<User>(user.get());
        ControllerLinkBuilder linkBuilder = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkBuilder.withRel(("all-users")));


        return resource;
    }

	@DeleteMapping("/jpausers/{id}")
    public void deleteUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));
		userRepository.delete(user.get());
     }

    @PostMapping("/jpausers")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpausers/{id}/posts")
    public List<Post> retriveUsersPosts(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user .isPresent())
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));

        List<Post> posts = user.get().getPosts();

        return posts;
    }

    @PostMapping("/jpausers/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (!user .isPresent())
            throw new UserNotFoundException(String.format("User with id '%s' not found", id));

        post.setUser(user.get());
        Post newpost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}").buildAndExpand(newpost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
