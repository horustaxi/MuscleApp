/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vas.muscleapp.dtos.queries.WorkoutSheetQueryDTO;
import com.vas.muscleapp.models.WorkoutSheet;
import com.vas.muscleapp.services.WorkoutSheetService;

/**
 *
 * @author Vinícius
 */
@RestController
public class WorkoutSheetController {

	private final WorkoutSheetService workoutSheetService;
	private final ModelMapper modelMapper;

	@Autowired
	public WorkoutSheetController(WorkoutSheetService workoutSheetService,
			ModelMapper modelMapper) {
		this.workoutSheetService = workoutSheetService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/workout-sheets/{id}")
	public ResponseEntity<WorkoutSheetQueryDTO> getById(@PathVariable Long id) {
		WorkoutSheet workoutSheet = workoutSheetService.findById(id);
		WorkoutSheetQueryDTO dto = modelMapper.map(workoutSheet, WorkoutSheetQueryDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/workout-plans/{workoutPlanId}/workout-sheets")
	public ResponseEntity<List<WorkoutSheetQueryDTO>> getAllByWorkoutPlan(
			@PathVariable Long workoutPlanId) {
		List<WorkoutSheet> workoutSheet = workoutSheetService.getAllByWorkoutPlan(workoutPlanId);
		Type listType = new TypeToken<List<WorkoutSheetQueryDTO>>() {
		}.getType();
		List<WorkoutSheetQueryDTO> workoutSheetDTOs = modelMapper.map(workoutSheet, listType);
		return new ResponseEntity<>(workoutSheetDTOs, HttpStatus.OK);
	}

}
