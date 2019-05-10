package com.vas.muscleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vas.muscleapp.models.WorkoutSheet;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(exported = false)
public interface WorkoutSheetRepository extends JpaRepository<WorkoutSheet, Long> {

}
