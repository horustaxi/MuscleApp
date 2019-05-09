/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.dtos.ExerciseDTO;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.services.ExerciseService;
import java.net.URI;
import java.lang.reflect.Type;
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
    public ResponseEntity<?> save(@RequestBody Exercise exercise) {
        exercise = exerciseService.save(exercise);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(exercise.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/exercises")
    public @ResponseBody
    ResponseEntity<List<ExerciseDTO>> getAllActives() {
        List<Exercise> exercises = exerciseService.findAllActives();
        Type listType = new TypeToken<List<ExerciseDTO>>() {
        }.getType();
        List<ExerciseDTO> exercisesDTO = modelMapper.map(exercises, listType);
        return new ResponseEntity<>(exercisesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "exercises/{id}")
    public @ResponseBody
    ResponseEntity<ExerciseDTO> getById(@PathVariable Long id) {
        // TODO throw an exception if it can't find exercise
        Exercise exercise = exerciseService.findById(id);
        ExerciseDTO exerciseDTO = modelMapper.map(exercise, ExerciseDTO.class);
        return new ResponseEntity<>(exerciseDTO, HttpStatus.OK);
    }

}
