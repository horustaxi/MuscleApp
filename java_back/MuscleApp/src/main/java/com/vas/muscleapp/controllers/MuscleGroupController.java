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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vas.muscleapp.dtos.MuscleGroupDTO;
import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.services.MuscleGroupService;

/**
 *
 * @author Vinicius
 */
@RestController
public class MuscleGroupController {

	private final MuscleGroupService muscleGroupService;
	private final ModelMapper modelMapper;

	@Autowired
	public MuscleGroupController(MuscleGroupService muscleGroupService, ModelMapper modelMapper) {
		this.muscleGroupService = muscleGroupService;
		this.modelMapper = modelMapper;
	}

	@PostMapping(value = "/muscle-groups")
	public ResponseEntity<?> save(@RequestBody MuscleGroup muscleGroup) {
		muscleGroup = muscleGroupService.save(muscleGroup);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(muscleGroup.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/muscle-groups")
	public @ResponseBody ResponseEntity<Set<MuscleGroupDTO>> getAllActives() {
		Set<MuscleGroup> muscleGroups = muscleGroupService.findAllActives();
		Type listType = new TypeToken<Set<MuscleGroupDTO>>() {
		}.getType();
		Set<MuscleGroupDTO> muscleGroupsDTO = modelMapper.map(muscleGroups, listType);
		return new ResponseEntity<>(muscleGroupsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "muscle-groups/{id}")
	public @ResponseBody ResponseEntity<MuscleGroupDTO> getById(@PathVariable Long id) {
		MuscleGroup muscleGroup = muscleGroupService.findById(id);
		MuscleGroupDTO muscleGroupDTO = modelMapper.map(muscleGroup, MuscleGroupDTO.class);
		return new ResponseEntity<>(muscleGroupDTO, HttpStatus.OK);
	}

}
