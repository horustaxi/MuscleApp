package com.vas.muscleapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.Workset;

/**
 *
 * @author Vinicius
 */
@Repository
public interface WorksetRepository extends JpaRepository<Workset, Long> {

	List<Workset> findByWorkoutSheetId(Long id);

}
