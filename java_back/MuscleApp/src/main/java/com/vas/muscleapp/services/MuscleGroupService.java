package com.vas.muscleapp.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.repositories.MuscleGroupRepository;

@Service
public class MuscleGroupService implements BaseService<MuscleGroup, Long> {

	@Autowired
	private final MuscleGroupRepository repository;

	public MuscleGroupService(MuscleGroupRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public MuscleGroup save(MuscleGroup entity) {
		return repository.save(entity);
	}

	@Override
	public MuscleGroup findById(Long id) {
		return repository.findById(id).get();
	}

	public Set<MuscleGroup> findAllActives() {
		return repository.findMuscleGroupByActive(true);
	}

}
