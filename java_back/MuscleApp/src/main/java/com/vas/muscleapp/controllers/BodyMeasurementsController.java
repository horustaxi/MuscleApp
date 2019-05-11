/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vas.muscleapp.dtos.BodyMeasurementsDTO;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.services.BodyMeasurementsService;

/**
 *
 * @author Vinícius
 */
@RestController
public class BodyMeasurementsController {

	private final BodyMeasurementsService bodyMeasurementsService;
	private final ModelMapper modelMapper;

	@Autowired
	public BodyMeasurementsController(BodyMeasurementsService bodyMeasurementsService,
			ModelMapper modelMapper) {
		this.bodyMeasurementsService = bodyMeasurementsService;
		this.modelMapper = modelMapper;
	}

	@PostMapping(value = "/user/{userId}/body-measurements")
	public ResponseEntity<?> save(@PathVariable Long userId,
			@RequestBody BodyMeasurements bodyMeasurements) {
		User measuredUser = new User();
		measuredUser.setId(userId);
		bodyMeasurements.setMeasuredUser(measuredUser);
		bodyMeasurementsService.save(bodyMeasurements);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/user/{userId}/bodymeasurements").buildAndExpand(bodyMeasurements.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/body-measurements/{id}")
	public ResponseEntity<BodyMeasurementsDTO> getById(@PathVariable Long id) {
		BodyMeasurements bodyMeasurements = bodyMeasurementsService.findById(id);
		BodyMeasurementsDTO dto = modelMapper.map(bodyMeasurements, BodyMeasurementsDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}/body-measurements")
	public ResponseEntity<Set<BodyMeasurementsDTO>> getAllByUser(@PathVariable Long userId) {
		Set<BodyMeasurements> bodyMeasurements = bodyMeasurementsService.getAllByUserId(userId);
		Type listType = new TypeToken<Set<BodyMeasurementsDTO>>() {
		}.getType();
		Set<BodyMeasurementsDTO> bodyMeasurementsDTOs = modelMapper.map(bodyMeasurements, listType);
		return new ResponseEntity<>(bodyMeasurementsDTOs, HttpStatus.OK);
	}

}
