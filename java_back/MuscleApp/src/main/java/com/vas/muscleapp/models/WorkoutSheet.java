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
@Entity(name = "workout_sheet")
public class WorkoutSheet extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 100)
	@NotEmpty
	private String description;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private WorkoutPlan workoutPlan;
	@OneToMany(mappedBy = "workoutSheet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Workset> worksets = new HashSet<>();

	public WorkoutSheet(String description, WorkoutPlan workoutPlan) {
		this.description = description;
		this.workoutPlan = workoutPlan;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Objects.hashCode(getId());
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
		if (!(obj instanceof WorkoutSheet)) {
			return false;
		}
		final WorkoutSheet other = (WorkoutSheet) obj;
		return Objects.equals(getId(), other.getId());
	}

}
