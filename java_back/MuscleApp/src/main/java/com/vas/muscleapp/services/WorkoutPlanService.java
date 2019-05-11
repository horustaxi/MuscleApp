/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.WorkoutPlan;
import com.vas.muscleapp.repositories.WorkoutPlanRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class WorkoutPlanService implements BaseService<WorkoutPlan, Long> {

	@Autowired
	private final WorkoutPlanRepository workoutPlanRepository;

	public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository) {
		this.workoutPlanRepository = workoutPlanRepository;
	}

	@Override
	public WorkoutPlan save(WorkoutPlan workoutPlan) {
		return workoutPlanRepository.save(workoutPlan);
	}

	public List<WorkoutPlan> getAllCreatedToUserId(Long userId) {
		return workoutPlanRepository.getAllByCreatedToId(userId);
	}

	public List<WorkoutPlan> getAllCreatedByUserId(Long userId) {
		return workoutPlanRepository.getAllByCreatedById(userId);
	}

	@Override
	public WorkoutPlan findById(Long id) {
		return workoutPlanRepository.findById(id).get();
	}

}
