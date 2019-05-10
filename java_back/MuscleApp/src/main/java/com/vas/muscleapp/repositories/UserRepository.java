package com.vas.muscleapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vas.muscleapp.models.User;

/**
 *
 * @author Vinicius
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user", exported = false)
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByEmail(String email);

}
