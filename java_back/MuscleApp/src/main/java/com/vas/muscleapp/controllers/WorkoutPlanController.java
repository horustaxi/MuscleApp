/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vas.muscleapp.dtos.WorkoutPlanDTO;
import com.vas.muscleapp.models.WorkoutPlan;
import com.vas.muscleapp.services.WorkoutPlanService;

/**
 *
 * @author Vinícius
 */
@RestController
public class WorkoutPlanController {

	private final WorkoutPlanService workoutPlanService;
	private final ModelMapper modelMapper;

	@Autowired
	public WorkoutPlanController(WorkoutPlanService workoutPlanService, ModelMapper modelMapper) {
		this.workoutPlanService = workoutPlanService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/workout-plan/{id}")
	public ResponseEntity<WorkoutPlanDTO> getById(@PathVariable Long id) {
		WorkoutPlan workoutPlan = workoutPlanService.findById(id);
		WorkoutPlanDTO dto = modelMapper.map(workoutPlan, WorkoutPlanDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/workout-plan")
	public ResponseEntity<List<WorkoutPlanDTO>> getAllByCreatedByUserOrCreatedToUser(
			@RequestParam(name = "created-to") Optional<Long> createdTo,
			@RequestParam(name = "created-by") Optional<Long> createdBy) {
		if (!createdTo.isPresent() && !createdBy.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Expected either parameter created-to or created-by");
		}
		if (createdTo.isPresent() && createdBy.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Expected only one of the parameters created-to or created-by");
		}
		List<WorkoutPlan> workoutPlan = new ArrayList<>();
		if (createdTo.isPresent())
			workoutPlan = workoutPlanService.getAllCreatedToUserId(createdTo.get());
		if (createdBy.isPresent())
			workoutPlan = workoutPlanService.getAllCreatedByUserId(createdBy.get());
		Type listType = new TypeToken<List<WorkoutPlanDTO>>() {
		}.getType();
		List<WorkoutPlanDTO> workoutPlanDTOs = modelMapper.map(workoutPlan, listType);
		return new ResponseEntity<>(workoutPlanDTOs, HttpStatus.OK);
	}

}
