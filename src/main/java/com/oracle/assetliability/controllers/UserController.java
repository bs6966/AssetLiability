package com.oracle.assetliability.controllers;

import com.oracle.assetliability.models.Authority;
import com.oracle.assetliability.models.User;
import com.oracle.assetliability.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("register")
    public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Authority role = new Authority();
        role.setAuthority("ROLE_USER");
        role.setUser(user);
        user.setAuthorities(Set.of(role));

        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
