/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.exercise;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinícius
 */
@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    Exercise save(Exercise exercise) {        
//        if (exerciseRepository) {
//            
//        }
        return exerciseRepository.save(exercise);
    }

    List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    Exercise findById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public void deleteAllInBatch() {
        exerciseRepository.deleteAllInBatch();
    }
    
}
