package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.repositories.WorksetRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class WorksetService implements BaseService<Workset, Long> {

	@Autowired
	private final WorksetRepository worksetRepository;

	public WorksetService(WorksetRepository worksetRepository) {
		this.worksetRepository = worksetRepository;
	}

	@Override
	public Workset save(Workset workset) {
		return worksetRepository.save(workset);
	}

	public List<Workset> getAllByWorkoutSheet(Long workoutSheetId) {
		return worksetRepository.findByWorkoutSheetId(workoutSheetId);
	}

	@Override
	public Workset findById(Long id) {
		return worksetRepository.findById(id).get();
	}

}
