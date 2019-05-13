/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vas.muscleapp.dtos.commands.ExerciseCreateCommandDTO;
import com.vas.muscleapp.dtos.queries.ExerciseQueryDTO;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.services.ExerciseService;

/**
 *
 * @author Vinicius
 */
@RestController
public class ExerciseController {

	private final ExerciseService exerciseService;
	private final ModelMapper modelMapper;

	@Autowired
	public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
		this.exerciseService = exerciseService;
		this.modelMapper = modelMapper;
	}

	@PostMapping(value = "/exercises")
	public ResponseEntity<?> save(@RequestBody ExerciseCreateCommandDTO exercise) {
		Exercise exerciseNew = exerciseService.save(modelMapper.map(exercise, Exercise.class));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(exerciseNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/exercises")
	public @ResponseBody ResponseEntity<List<ExerciseQueryDTO>> getAllActives() {
		List<Exercise> exercises = exerciseService.findAllActives();
		Type listType = new TypeToken<List<ExerciseQueryDTO>>() {
		}.getType();
		List<ExerciseQueryDTO> exercisesDTO = modelMapper.map(exercises, listType);
		return new ResponseEntity<>(exercisesDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/exercises/{id}")
	public @ResponseBody ResponseEntity<ExerciseQueryDTO> getById(@PathVariable Long id) {
		Exercise exercise = exerciseService.findById(id);
		ExerciseQueryDTO exerciseDTO = modelMapper.map(exercise, ExerciseQueryDTO.class);
		return new ResponseEntity<>(exerciseDTO, HttpStatus.OK);
	}

}
