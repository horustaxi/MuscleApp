package com.vas.muscleapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.WorkoutPlan;

/**
 *
 * @author Vinicius
 */
@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {

	List<WorkoutPlan> getAllByCreatedToId(Long userId);

	List<WorkoutPlan> getAllByCreatedById(Long userId);

}
