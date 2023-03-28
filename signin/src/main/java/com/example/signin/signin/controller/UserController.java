package com.example.signin.signin.controller;


import com.example.signin.signin.entity.User;
import com.example.signin.signin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userr;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/see")
    @PreAuthorize("hasRole('USER')")
    public void save(@RequestBody User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userr.save(user);
    }

   @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{username}")
   public ResponseEntity<String>Delete(@PathVariable("username") String username) {
        userr.deleteByUserName(username);

        return new ResponseEntity<>("success deleted",HttpStatus.OK);
   }
}
