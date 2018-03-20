/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user;

import com.vas.muscleapp.bodyMeasurements.BodyMeasurements;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vinícius
 */
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping(value = "/register")
    public void register(@RequestBody User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }
    
    @GetMapping(value = "/user/{email:.+}")
    public ResponseEntity<User> userLogado(@PathVariable String email) {
        return new ResponseEntity<>(this.userRepository.findUserByEmail(email), HttpStatus.OK);
    }
    
    @GetMapping(value = "/user/{userId}/bodymeasurements")
    public ResponseEntity<Set<BodyMeasurements>> getBodyMeasurements(@PathVariable Long userId) {
        User user = this.userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user.getBodyMeasurementses(), HttpStatus.OK);
    }
    
}
