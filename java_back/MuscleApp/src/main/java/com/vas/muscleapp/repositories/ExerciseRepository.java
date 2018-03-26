package com.vas.muscleapp.repositories;

import com.vas.muscleapp.models.Exercise;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(collectionResourceRel = "exercise", path = "exercise", exported = false)
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    public Optional<Exercise> findExerciseByName(String name);
    
}
