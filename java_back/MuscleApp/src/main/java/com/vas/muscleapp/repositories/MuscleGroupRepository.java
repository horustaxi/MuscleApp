package com.vas.muscleapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vas.muscleapp.models.MuscleGroup;

/**
 *
 * @author Vinícius
 */
@RepositoryRestResource(collectionResourceRel = "musclegroup", exported = false)
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

	public Optional<MuscleGroup> findMuscleGroupByName(String name);

}
