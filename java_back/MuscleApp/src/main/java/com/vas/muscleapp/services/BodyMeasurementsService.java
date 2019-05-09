/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.services;

import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
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

//    public List<BodyMeasurementsDTO> getBodyMeasurementsByUserId(Long userId) {
//        ModelMapper modelMapper = new ModelMapper();
//        User user = userService.findById(userId);
//        List<BodyMeasurementsDTO> bodyMeasurementsDTOs = new ArrayList<>();
//        
//        user.getBodyMeasurementses().forEach(
//                (bm) -> bodyMeasurementsDTOs.add(modelMapper.map(bm, BodyMeasurementsDTO.class))
//        );
//        
//        return bodyMeasurementsDTOs;
//    }

}
