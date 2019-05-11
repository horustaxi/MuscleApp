package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.WorksetExercise;
import com.vas.muscleapp.repositories.WorksetExerciseRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class WorksetExerciseService implements BaseService<WorksetExercise, Long> {

	@Autowired
	private final WorksetExerciseRepository worksetExerciseRepository;

	public WorksetExerciseService(WorksetExerciseRepository worksetExerciseRepository) {
		this.worksetExerciseRepository = worksetExerciseRepository;
	}

	@Override
	public WorksetExercise save(WorksetExercise worksetExercise) {
		return worksetExerciseRepository.save(worksetExercise);
	}

	public List<WorksetExercise> getAllByWorkset(Long worksetId) {
		return worksetExerciseRepository.findByWorksetId(worksetId);
	}

	@Override
	public WorksetExercise findById(Long id) {
		return worksetExerciseRepository.findById(id).get();
	}

}
