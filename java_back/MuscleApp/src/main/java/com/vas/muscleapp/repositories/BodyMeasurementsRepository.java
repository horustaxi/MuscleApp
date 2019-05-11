/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.BodyMeasurements;

/**
 *
 * @author Vinícius
 */
@Repository
public interface BodyMeasurementsRepository extends JpaRepository<BodyMeasurements, Long> {
	
	Set<BodyMeasurements> findByMeasuredUserId(Long userId);

}
