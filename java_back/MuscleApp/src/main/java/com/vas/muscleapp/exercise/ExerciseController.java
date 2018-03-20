/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.exercise;

import java.net.URI;
import java.util.List;
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

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping(value = "/exercises")
    public ResponseEntity<?> save(@RequestBody Exercise exercise) {
        // TODO verify if an exercise with the same name already exists
        exercise = exerciseRepository.save(exercise);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(exercise.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/exercises")
    public @ResponseBody ResponseEntity<List<Exercise>> getAll() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
    
    @GetMapping(value = "exercises/{id}")
    public @ResponseBody ResponseEntity<Exercise> get(@PathVariable Long id) {
        // TODO throw an exception if it can't find exercise
        Exercise exercise = exerciseRepository.findById(id).orElse(null);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

}
