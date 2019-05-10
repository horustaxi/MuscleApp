/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vas.muscleapp.models.BodyMeasurements;

/**
 *
 * @author Vinícius
 */
@RepositoryRestResource(collectionResourceRel = "bodymeasurements", exported = false)
public interface BodyMeasurementsRepository extends JpaRepository<BodyMeasurements, Long> {

}
