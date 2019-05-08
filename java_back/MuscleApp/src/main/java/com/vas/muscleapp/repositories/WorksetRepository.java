package com.vas.muscleapp.repositories;

import com.vas.muscleapp.models.Workset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(exported = false)
public interface WorksetRepository extends JpaRepository<Workset, Long> {
    
}
