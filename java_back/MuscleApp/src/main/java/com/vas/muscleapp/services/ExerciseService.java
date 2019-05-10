/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.exceptions.exercise.ExerciseAlreadyExistsException;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.repositories.ExerciseRepository;

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

	public Exercise save(Exercise exercise) {
		if (exerciseRepository.findExerciseByName(exercise.getName()).orElse(null) != null) {
			throw new ExerciseAlreadyExistsException(exercise.getName());
		}
		return exerciseRepository.save(exercise);
	}

	public List<Exercise> findAllActives() {
		return exerciseRepository.findExerciseByActive(Boolean.TRUE);
	}

	public Exercise findById(Long id) {
		return exerciseRepository.findById(id).get();
	}

}
