package com.vas.muscleapp.repositories;

import com.vas.muscleapp.models.WorkoutSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(exported = false)
public interface WorkoutSheetRepository extends JpaRepository<WorkoutSheet, Long> {
    
}
