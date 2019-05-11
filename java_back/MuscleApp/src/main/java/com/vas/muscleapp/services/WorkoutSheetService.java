/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.WorkoutSheet;
import com.vas.muscleapp.repositories.WorkoutSheetRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class WorkoutSheetService implements BaseService<WorkoutSheet, Long> {

	@Autowired
	private final WorkoutSheetRepository workoutSheetRepository;

	public WorkoutSheetService(WorkoutSheetRepository workoutSheetRepository) {
		this.workoutSheetRepository = workoutSheetRepository;
	}

	@Override
	public WorkoutSheet save(WorkoutSheet workoutSheet) {
		return workoutSheetRepository.save(workoutSheet);
	}

	public List<WorkoutSheet> getAllByWorkoutPlan(Long workoutPlanId) {
		return workoutSheetRepository.findByWorkoutPlanId(workoutPlanId);
	}

	@Override
	public WorkoutSheet findById(Long id) {
		return workoutSheetRepository.findById(id).get();
	}

}
