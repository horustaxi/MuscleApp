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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "workout_plan")
public class WorkoutPlan extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 100)
	@NotEmpty
	private String description;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User createdBy;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User createdTo;

	@OneToMany(mappedBy = "workoutPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private final Set<WorkoutSheet> workoutSheets = new HashSet<>();

	public WorkoutPlan(String description, User createdBy, User createdTo) {
		this.description = description;
		this.createdBy = createdBy;
		this.createdTo = createdTo;
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
