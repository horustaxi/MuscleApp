package com.vas.muscleapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.Muscle;

/**
 *
 * @author Vinícius
 */
@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Long> {

	public Optional<Muscle> findMuscleByName(String name);

	public List<Muscle> findMuscleByActive(Boolean active);

}
