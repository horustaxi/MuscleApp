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
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;

/**
 *
 * @author Vinícius
 */
@Service
public class BodyMeasurementsService {

	@Autowired
	private final BodyMeasurementsRepository bodyMeasurementsRepository;

	@Autowired
	private final UserService userService;

	public BodyMeasurementsService(BodyMeasurementsRepository bodyMeasurementsRepository,
			UserService userService) {
		this.bodyMeasurementsRepository = bodyMeasurementsRepository;
		this.userService = userService;
	}

	public void save(BodyMeasurements bodyMeasurements) {
		bodyMeasurementsRepository.save(bodyMeasurements);
	}

	public Set<BodyMeasurements> getBodyMeasurementsByUserId(Long userId) {
		User user = userService.findById(userId);
		return user.getBodyMeasurementses();
	}

}
