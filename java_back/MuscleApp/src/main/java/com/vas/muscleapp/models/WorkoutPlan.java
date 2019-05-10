package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Vinícius
 */
@Entity(name = "workout_plan")
public class WorkoutPlan extends BaseEntity implements Serializable {

	@Column(nullable = false, unique = false)
	@NotEmpty
	private String description;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User createdBy;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User createdTo;

	@OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
	private final Set<WorkoutSheet> workoutSheets = new HashSet<>();

	public WorkoutPlan() {
	}

	public WorkoutPlan(String description, User createdBy, User createdTo) {
		this.description = description;
		this.createdBy = createdBy;
		this.createdTo = createdTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty");
		}
		this.description = description.toLowerCase().trim();
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedTo(User createdTo) {
		this.createdTo = createdTo;
	}

	public User getCreatedTo() {
		return createdTo;
	}

	public Set<WorkoutSheet> getWorkoutSheets() {
		return workoutSheets;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(getId());
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
		if (!(obj instanceof WorkoutPlan)) {
			return false;
		}
		final WorkoutPlan other = (WorkoutPlan) obj;
		return Objects.equals(getId(), other.getId());
	}
}
