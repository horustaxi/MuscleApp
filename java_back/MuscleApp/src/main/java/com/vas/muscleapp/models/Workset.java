package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity(name = "workset")
public class Workset extends BaseEntity implements Serializable {

	private char letter;

	@OneToMany(mappedBy = "workset", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<WorksetExercise> worksetExercises = new HashSet<>();
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private WorkoutSheet workoutSheet;

	public Workset(char letter, WorkoutSheet workoutSheet) {
		this.letter = letter;
		this.workoutSheet = workoutSheet;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(getId());
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
		if (!(obj instanceof Workset)) {
			return false;
		}
		final Workset other = (Workset) obj;
		return Objects.equals(getId(), other.getId());
	}

}
