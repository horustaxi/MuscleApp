package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Vinicius
 */
@SuppressWarnings("serial")
@Entity(name = "user")
public class User extends BaseEntity implements Serializable {

	@Column(nullable = false)
	@NotEmpty
	private String name;
	@Column(nullable = false, unique = true)
	@NotEmpty
	@Email
	private String email;
	@Column(nullable = false)
	@NotEmpty
	@Size(min = 6, max = 100)
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "measuredUser", cascade = CascadeType.ALL)
	private Set<BodyMeasurements> bodyMeasurements = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "personalTrainnerUser", cascade = CascadeType.ALL)
	private Set<BodyMeasurements> bodyMeasurementsCreateds = new HashSet<>();
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private final Set<WorkoutPlan> workoutPlansCreated = new HashSet<>();
	@OneToMany(mappedBy = "createdTo", cascade = CascadeType.ALL)
	private Set<WorkoutPlan> workoutPlans = new HashSet<>();

	public User() {
	}

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception {
		this.password = password;
	}

	public void setBodyMeasurements(Set<BodyMeasurements> bodyMeasurementses) {
		this.bodyMeasurements = bodyMeasurementses;
	}

	public Set<BodyMeasurements> getBodyMeasurements() {
		return bodyMeasurements;
	}

	public void setWorkoutPlans(Set<WorkoutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
	}

	public Set<WorkoutPlan> getWorkoutPlansCreated() {
		return workoutPlansCreated;
	}

	public Set<WorkoutPlan> getWorkoutPlans() {
		return workoutPlans;
	}

	public void setBodyMeasurementsCreateds(Set<BodyMeasurements> bodyMeasurementsCreateds) {
		this.bodyMeasurementsCreateds = bodyMeasurementsCreateds;
	}

	public Set<BodyMeasurements> getBodyMeasurementsesCreateds() {
		return bodyMeasurementsCreateds;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.email);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		final User other = (User) obj;
		return Objects.equals(this.email, other.email);
	}

}
