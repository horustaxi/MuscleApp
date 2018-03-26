/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinícius
 */
@Service
public class BodyMeasurementsService {
    
    @Autowired
    private final BodyMeasurementsRepository bodyMeasurementsRepository;

    public BodyMeasurementsService(BodyMeasurementsRepository bodyMeasurementsRepository) {
        this.bodyMeasurementsRepository = bodyMeasurementsRepository;
    }
    
    public void save(BodyMeasurements bodyMeasurements) {
        bodyMeasurementsRepository.save(bodyMeasurements);
    }
    
}
