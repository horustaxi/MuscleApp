/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.repositories.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vinicius
 */
@RestController(value = "exercise")
public class ExerciseController {
    
    private final IExerciseRepository exerciseRepository;
    
    @Autowired
    public ExerciseController(IExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    
    @PostMapping
    public void save(@RequestBody Exercise exercise) {
        exerciseRepository.save(exercise);
    }
    
    @GetMapping
    public Object getAll() {
        return exerciseRepository.findAll();
    }
    
}
