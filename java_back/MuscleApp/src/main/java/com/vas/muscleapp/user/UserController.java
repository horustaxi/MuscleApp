/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user;

import com.vas.muscleapp.bodyMeasurements.BodyMeasurements;
import com.vas.muscleapp.user.exceptions.UserAlreadyExistsException;
import com.vas.muscleapp.user.exceptions.UserNotFoundException;
import java.util.List;
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
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        if (this.userRepository.findUserByEmail(user.getEmail()).orElse(null) != null) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @GetMapping(value = "/user/{email:.+}")
//    public ResponseEntity<User> userLogado(@PathVariable String email) {
//        User user = this.userRepository.findUserByEmail(email)
//                .orElseThrow(() -> new UserNotFoundException("email", email));
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    @GetMapping(value = "/user/{userId}/bodymeasurements")
    public ResponseEntity<List<BodyMeasurements>> getBodyMeasurements(@PathVariable Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("id", userId.toString()));
        return new ResponseEntity<>(user.getBodyMeasurementses(), HttpStatus.OK);
    }

}
