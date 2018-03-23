/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user;

import com.vas.muscleapp.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vinícius
 */
@RestController
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        if (this.userService.findUserByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        this.userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @GetMapping(value = "/user/{email:.+}")
//    public ResponseEntity<User> userLogado(@PathVariable String email) {
//        User user = this.userRepository.findUserByEmail(email)
//                .orElseThrow(() -> new UserNotFoundException("email", email));
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

}
