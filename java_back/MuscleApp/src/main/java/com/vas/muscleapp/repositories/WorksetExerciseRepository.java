package com.vas.muscleapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.WorksetExercise;

/**
 *
 * @author Vinicius
 */
@Repository
public interface WorksetExerciseRepository extends JpaRepository<WorksetExercise, Long> {

	List<WorksetExercise> findByWorksetId(Long id);

}
