/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vas.muscleapp.dtos.UserDTO;
import com.vas.muscleapp.exceptions.user.UserAlreadyExistsException;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.services.UserService;

/**
 *
 * @author Vinícius
 */
@RestController
public class UserController {

	private final UserService userService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ModelMapper modelMapper;

	@Autowired
	public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder,
			ModelMapper modelMapper) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.modelMapper = modelMapper;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody User user) throws Exception {
		if (userService.existsWithEmail(user.getEmail())) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		this.userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	// TODO missing test
	/*
	 * @GetMapping(value = "/users") public ResponseEntity<UserDTO>
	 * userByToken(@RequestHeader String authorization) throws Exception { String
	 * email = Jwts.parser().setSigningKey(SECRET.getBytes())
	 * .parseClaimsJws(authorization.replace(TOKEN_PREFIX,
	 * "")).getBody().getSubject(); User user = userService.findByEmail(email);
	 * UserDTO userDto = modelMapper.map(user, UserDTO.class); return new
	 * ResponseEntity<>(userDto, HttpStatus.OK); }
	 */

	@GetMapping(value = "/users")
	public ResponseEntity<UserDTO> getByEMail(@RequestParam(required = true) String email) {
		User user = userService.findByEmail(email);
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
}
