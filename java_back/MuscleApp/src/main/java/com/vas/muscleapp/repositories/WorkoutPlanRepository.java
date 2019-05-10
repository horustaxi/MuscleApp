package com.vas.muscleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vas.muscleapp.models.WorkoutPlan;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(exported = false)
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {

}
