package com.vas.muscleapp.repositories;

import com.vas.muscleapp.models.Muscle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Vinícius
 */
@RepositoryRestResource(collectionResourceRel = "muscle", exported = false)
public interface MuscleRepository extends JpaRepository<Muscle, Long> {

    public Optional<Muscle> findMuscleByName(String name);
    public List<Muscle> findMuscleByActive(Boolean active);

}
