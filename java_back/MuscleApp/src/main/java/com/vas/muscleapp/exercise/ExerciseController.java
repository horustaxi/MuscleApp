/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.exercise;

import com.vas.muscleapp.exercise.Exercise;
import java.net.URI;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Vinicius
 */
@RestController(value = "exercises")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Exercise exercise) {
        exercise = exerciseRepository.save(exercise);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(exercise.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
//    @GetMapping(value = "/{exerciseId}")
//    public Exercise get(@PathVariable Long exerciseId) {
//        return exerciseRepository.findById(exerciseId).orElse(null);
//    }

    @GetMapping
    public Iterable<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

}
