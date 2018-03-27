/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import com.vas.muscleapp.dtos.UserDTO;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.exceptions.user.UserNotFoundException;
import com.vas.muscleapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinícius
 */
@Service
public class UserService {
    
    private final UserRepository userReporitory;

    @Autowired
    public UserService(UserRepository userReporitory) {
        this.userReporitory = userReporitory;
    }

    public UserDTO findUserByEmail(String email) {
        ModelMapper modelMapper = new ModelMapper();
        User user = userReporitory.findUserByEmail(email).orElse(null);
        return user != null ? modelMapper.map(user, UserDTO.class) : null;
    }

    public User save(User user) {
        return userReporitory.save(user);
    }

    public User findById(Long userId) {
        return userReporitory.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("id", userId.toString()));
    }

    public void deleteAll() {
        userReporitory.deleteAll();
    }
    
}
