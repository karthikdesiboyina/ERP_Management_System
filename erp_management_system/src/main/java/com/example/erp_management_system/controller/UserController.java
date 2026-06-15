package com.example.erp_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp_management_system.entity.User;
import com.example.erp_management_system.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        System.out.println("Email: " + user.getEmail());

        User dbUser = userService.login(user.getEmail());

        System.out.println("DB User: " + dbUser);

        if (dbUser != null &&
                dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(dbUser);
        }

        return ResponseEntity.badRequest().body("Invalid Credentials");
    }

    // Get All Users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/count")
    public long getUserCount() {
        return userService.getUserCount();
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        user.setUserId(id);
        return userService.saveUser(user);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted successfully";
    }
}