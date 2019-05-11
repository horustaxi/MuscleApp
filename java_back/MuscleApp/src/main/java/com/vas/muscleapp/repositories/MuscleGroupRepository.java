package com.vas.muscleapp.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.MuscleGroup;

/**
 *
 * @author Vinícius
 */
@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

	public Optional<MuscleGroup> findMuscleGroupByName(String name);

	public Set<MuscleGroup> findMuscleGroupByActive(Boolean active);

}
