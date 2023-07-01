package com.emandi.adminservice.controller;


import com.emandi.adminservice.model.User;
import com.emandi.adminservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("user inserted successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User userDto) {
        User user = userService.updateUser(id, userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable("id") Integer id) {
        User user = userService.findByUserId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<?> findAllUsers() {
        List<User> userlist = (List<User>) userService.findAllUserDetails();
        return new ResponseEntity<>(userlist, HttpStatus.OK);

    }
}
