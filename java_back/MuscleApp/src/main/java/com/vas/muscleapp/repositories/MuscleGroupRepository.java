package com.vas.muscleapp.repositories;

import com.vas.muscleapp.models.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Vinícius
 */
@RepositoryRestResource(collectionResourceRel = "musclegroup", exported = false)
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

    public MuscleGroup findMuscleGroupByName(String name);
        
}
