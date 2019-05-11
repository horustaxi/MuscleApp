package com.vas.muscleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.WorkoutSheet;

/**
 *
 * @author Vinicius
 */
@Repository
public interface WorkoutSheetRepository extends JpaRepository<WorkoutSheet, Long> {

}
