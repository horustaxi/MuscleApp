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

import com.vas.muscleapp.dtos.queries.WorksetExerciseQueryDTO;
import com.vas.muscleapp.dtos.queries.WorksetQueryDTO;
import com.vas.muscleapp.models.WorksetExercise;
import com.vas.muscleapp.services.WorksetExerciseService;

/**
 *
 * @author Vinícius
 */
@RestController
public class WorksetExerciseController {

	private final WorksetExerciseService worksetExerciseService;
	private final ModelMapper modelMapper;

	@Autowired
	public WorksetExerciseController(WorksetExerciseService worksetExerciseService,
			ModelMapper modelMapper) {
		this.worksetExerciseService = worksetExerciseService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/workset-exercises/{id}")
	public ResponseEntity<WorksetExerciseQueryDTO> getById(@PathVariable Long id) {
		WorksetExercise worksetExercise = worksetExerciseService.findById(id);
		WorksetExerciseQueryDTO dto = modelMapper.map(worksetExercise, WorksetExerciseQueryDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/worksets/{worksetId}/workset-exercises")
	public ResponseEntity<List<WorksetExerciseQueryDTO>> getAllByWorkset(@PathVariable Long worksetId) {
		List<WorksetExercise> worksetExercise = worksetExerciseService.getAllByWorkset(worksetId);
		Type listType = new TypeToken<List<WorksetQueryDTO>>() {
		}.getType();
		List<WorksetExerciseQueryDTO> worksetExerciseDTOs = modelMapper.map(worksetExercise, listType);
		return new ResponseEntity<>(worksetExerciseDTOs, HttpStatus.OK);
	}

}
