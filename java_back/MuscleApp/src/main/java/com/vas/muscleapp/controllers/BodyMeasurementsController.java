/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.services.UserService;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.models.BodyMeasurements;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vinícius
 */
@RestController
public class BodyMeasurementsController {

    private final UserService userService;

    @Autowired
    public BodyMeasurementsController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping(value = "/user/{userId}/bodymeasurements")
    public ResponseEntity<List<BodyMeasurements>> getBodyMeasurements(@PathVariable Long userId) {
        User user = this.userService.findById(userId);
        return new ResponseEntity<>(user.getBodyMeasurementses(), HttpStatus.OK);
    }

}
