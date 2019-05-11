package com.vas.muscleapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vas.muscleapp.models.User;

/**
 *
 * @author Vinicius
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByEmail(String email);

}
