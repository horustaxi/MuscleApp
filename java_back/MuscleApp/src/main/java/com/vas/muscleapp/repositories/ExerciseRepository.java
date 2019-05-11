package com.vas.muscleapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.Exercise;

/**
 *
 * @author Vinicius
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	public Optional<Exercise> findExerciseByName(String name);

	public List<Exercise> findExerciseByActive(Boolean active);

}
