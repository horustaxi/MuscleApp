/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.dtos.BodyMeasurementsDTO;
import com.vas.muscleapp.services.UserService;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.services.BodyMeasurementsService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Vinícius
 */

// TODO missing tests
@RestController
public class BodyMeasurementsController {

    private final BodyMeasurementsService bodyMeasurementsService;

    @Autowired
    public BodyMeasurementsController(BodyMeasurementsService bodyMeasurementsService) {
        this.bodyMeasurementsService = bodyMeasurementsService;
    }

    @PostMapping(value = "/user/{userId}/bodymeasurements")
    public ResponseEntity<?> save(@PathVariable Long userId,
            @RequestBody BodyMeasurements bodyMeasurements) {
        User measuredUser = new User();
        measuredUser.setId(userId);
        bodyMeasurements.setMeasuredUser(measuredUser);
        bodyMeasurementsService.save(bodyMeasurements);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/user/{userId}/bodymeasurements")
                .buildAndExpand(bodyMeasurements.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/user/{userId}/bodymeasurements")
    public ResponseEntity<List<BodyMeasurementsDTO>> getBodyMeasurements(@PathVariable Long userId) {
        List<BodyMeasurementsDTO> bodyMeasurementsDTOs = bodyMeasurementsService.getBodyMeasurementsByUserId(userId);
        return new ResponseEntity<>(bodyMeasurementsDTOs, HttpStatus.OK);
    }

}
