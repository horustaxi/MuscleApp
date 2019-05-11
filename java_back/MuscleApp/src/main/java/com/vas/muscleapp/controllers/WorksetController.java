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

import com.vas.muscleapp.dtos.WorksetDTO;
import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.services.WorksetService;

/**
 *
 * @author Vinícius
 */
@RestController
public class WorksetController {

	private final WorksetService worksetService;
	private final ModelMapper modelMapper;

	@Autowired
	public WorksetController(WorksetService worksetService, ModelMapper modelMapper) {
		this.worksetService = worksetService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/worksets/{id}")
	public ResponseEntity<WorksetDTO> getById(@PathVariable Long id) {
		Workset workset = worksetService.findById(id);
		WorksetDTO dto = modelMapper.map(workset, WorksetDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/workout-sheets/{workoutSheetId}/worksets")
	public ResponseEntity<List<WorksetDTO>> getAllByWorkoutSheet(
			@PathVariable Long workoutSheetId) {
		List<Workset> workset = worksetService.getAllByWorkoutSheet(workoutSheetId);
		Type listType = new TypeToken<List<WorksetDTO>>() {
		}.getType();
		List<WorksetDTO> worksetDTOs = modelMapper.map(workset, listType);
		return new ResponseEntity<>(worksetDTOs, HttpStatus.OK);
	}

}
