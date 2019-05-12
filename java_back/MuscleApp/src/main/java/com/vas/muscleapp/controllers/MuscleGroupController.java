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

import com.vas.muscleapp.dtos.queries.MuscleGroupQueryDTO;
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
	public @ResponseBody ResponseEntity<Set<MuscleGroupQueryDTO>> getAllActives() {
		Set<MuscleGroup> muscleGroups = muscleGroupService.findAllActives();
		Type listType = new TypeToken<Set<MuscleGroupQueryDTO>>() {
		}.getType();
		Set<MuscleGroupQueryDTO> muscleGroupsDTO = modelMapper.map(muscleGroups, listType);
		return new ResponseEntity<>(muscleGroupsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "muscle-groups/{id}")
	public @ResponseBody ResponseEntity<MuscleGroupQueryDTO> getById(@PathVariable Long id) {
		MuscleGroup muscleGroup = muscleGroupService.findById(id);
		MuscleGroupQueryDTO muscleGroupDTO = modelMapper.map(muscleGroup, MuscleGroupQueryDTO.class);
		return new ResponseEntity<>(muscleGroupDTO, HttpStatus.OK);
	}

}
