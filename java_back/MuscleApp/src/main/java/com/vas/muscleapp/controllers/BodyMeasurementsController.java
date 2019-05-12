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

import com.vas.muscleapp.dtos.queries.BodyMeasurementsQueryDTO;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.services.BodyMeasurementsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author Vinícius
 */
@RestController
@Api(tags = { "Body Measurements" })
public class BodyMeasurementsController {

	private final BodyMeasurementsService bodyMeasurementsService;
	private final ModelMapper modelMapper;

	@Autowired
	public BodyMeasurementsController(BodyMeasurementsService bodyMeasurementsService,
			ModelMapper modelMapper) {
		this.bodyMeasurementsService = bodyMeasurementsService;
		this.modelMapper = modelMapper;
	}

	@ApiOperation(value = "Create a body measurement for a user created by another (or de the same) user")
	@PostMapping(value = "/users/{userId}/body-measurements")
	public ResponseEntity<URI> save(@PathVariable Long userId,
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

	@ApiOperation(value = "Returns a body measurement with specified ID", response = BodyMeasurementsQueryDTO.class)
	@GetMapping(value = "/body-measurements/{id}")
	public ResponseEntity<BodyMeasurementsQueryDTO> getById(@PathVariable Long id) {
		BodyMeasurements bodyMeasurements = bodyMeasurementsService.findById(id);
		BodyMeasurementsQueryDTO dto = modelMapper.map(bodyMeasurements, BodyMeasurementsQueryDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/users/{userId}/body-measurements")
	public ResponseEntity<Set<BodyMeasurementsQueryDTO>> getAllByUser(@PathVariable Long userId) {
		Set<BodyMeasurements> bodyMeasurements = bodyMeasurementsService.getAllByUserId(userId);
		Type listType = new TypeToken<Set<BodyMeasurementsQueryDTO>>() {
		}.getType();
		Set<BodyMeasurementsQueryDTO> bodyMeasurementsDTOs = modelMapper.map(bodyMeasurements, listType);
		return new ResponseEntity<>(bodyMeasurementsDTOs, HttpStatus.OK);
	}

}
