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

import com.vas.muscleapp.dtos.WorkoutSheetDTO;
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

	@GetMapping(value = "/workout-sheet/{id}")
	public ResponseEntity<WorkoutSheetDTO> getById(@PathVariable Long id) {
		WorkoutSheet workoutSheet = workoutSheetService.findById(id);
		WorkoutSheetDTO dto = modelMapper.map(workoutSheet, WorkoutSheetDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/workout-plan/{workoutPlanId}/workout-sheet")
	public ResponseEntity<List<WorkoutSheetDTO>> getAllByCreatedByUserOrCreatedToUser(
			@PathVariable Long workoutPlanId) {
		List<WorkoutSheet> workoutSheet = workoutSheetService.getAllByWorkoutPlan(workoutPlanId);
		Type listType = new TypeToken<List<WorkoutSheetDTO>>() {
		}.getType();
		List<WorkoutSheetDTO> workoutSheetDTOs = modelMapper.map(workoutSheet, listType);
		return new ResponseEntity<>(workoutSheetDTOs, HttpStatus.OK);
	}

}
