/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.repositories.MuscleRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class MuscleService {

	private final MuscleRepository muscleRepository;

	@Autowired
	public MuscleService(MuscleRepository muscleRepository) {
		this.muscleRepository = muscleRepository;
	}

	public Muscle save(Muscle muscle) {
		return muscleRepository.save(muscle);
	}

	public List<Muscle> findAllActives() {
		return muscleRepository.findMuscleByActive(Boolean.TRUE);
	}

	public Muscle findById(Long id) {
		return muscleRepository.findById(id).get();
	}

}
