package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class User extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 100)
	@NotEmpty
	private String name;
	@Column(nullable = false, length = 100, unique = true)
	@NotEmpty
	@Email
	private String email;
	@Column(nullable = false)
	@NotEmpty
	@Size(min = 6, max = 100)
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "measuredUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<BodyMeasurements> bodyMeasurements = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "personalTrainnerUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<BodyMeasurements> bodyMeasurementsCreateds = new HashSet<>();
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private final Set<WorkoutPlan> workoutPlansCreated = new HashSet<>();
	@OneToMany(mappedBy = "createdTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<WorkoutPlan> workoutPlans = new HashSet<>();

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
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
