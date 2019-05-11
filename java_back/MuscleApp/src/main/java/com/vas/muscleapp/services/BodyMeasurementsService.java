/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class BodyMeasurementsService implements BaseService<BodyMeasurements, Long> {

	@Autowired
	private final BodyMeasurementsRepository bodyMeasurementsRepository;

	public BodyMeasurementsService(BodyMeasurementsRepository bodyMeasurementsRepository) {
		this.bodyMeasurementsRepository = bodyMeasurementsRepository;
	}

	@Override
	public BodyMeasurements save(BodyMeasurements bodyMeasurements) {
		return bodyMeasurementsRepository.save(bodyMeasurements);
	}

	public Set<BodyMeasurements> getAllByUserId(Long userId) {
		return bodyMeasurementsRepository.findByMeasuredUserId(userId);
	}

	@Override
	public BodyMeasurements findById(Long id) {
		return bodyMeasurementsRepository.findById(id).get();
	}

}
