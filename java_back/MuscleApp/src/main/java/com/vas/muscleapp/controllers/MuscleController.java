/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vas.muscleapp.dtos.MuscleDTO;
import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.services.MuscleService;

/**
 *
 * @author Vinicius
 */
@RestController
public class MuscleController {

	private final MuscleService muscleService;
	private final ModelMapper modelMapper;

	@Autowired
	public MuscleController(MuscleService muscleService, ModelMapper modelMapper) {
		this.muscleService = muscleService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/muscles/{id}")
	public @ResponseBody ResponseEntity<MuscleDTO> getById(@PathVariable Long id) {
		Muscle muscle = muscleService.findById(id);
		MuscleDTO muscleDTO = modelMapper.map(muscle, MuscleDTO.class);
		return new ResponseEntity<>(muscleDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/muscles")
	public @ResponseBody ResponseEntity<List<MuscleDTO>> getAllActives() {
		List<Muscle> muscles = muscleService.findAllActives();
		Type listType = new TypeToken<List<MuscleDTO>>() {
		}.getType();
		List<MuscleDTO> musclesDTO = modelMapper.map(muscles, listType);
		return new ResponseEntity<>(musclesDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/muscle-groups/{muscleGroupId}/muscles")
	public @ResponseBody ResponseEntity<Set<MuscleDTO>> getAllByMuscleGroup(
			@PathVariable Long muscleGroupId) {
		Set<Muscle> muscles = muscleService.findAllByMuscleGroup(muscleGroupId);
		Type listType = new TypeToken<Set<MuscleDTO>>() {
		}.getType();
		Set<MuscleDTO> musclesDTO = modelMapper.map(muscles, listType);
		return new ResponseEntity<>(musclesDTO, HttpStatus.OK);
	}

}
