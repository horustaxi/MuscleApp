/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.repositories.MuscleRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class MuscleService implements BaseService<Muscle, Long> {

	private final MuscleRepository repository;

	@Autowired
	public MuscleService(MuscleRepository muscleRepository) {
		this.repository = muscleRepository;
	}

	@Override
	public Muscle save(Muscle muscle) {
		return repository.save(muscle);
	}

	public List<Muscle> findAllActives() {
		return repository.findMuscleByActive(Boolean.TRUE);
	}

	@Override
	public Muscle findById(Long id) {
		return repository.findById(id).get();
	}

	public Set<Muscle> findAllByMuscleGroup(Long muscleGroupId) {
		return repository.findByMuscleGroupId(muscleGroupId);
	}

}
