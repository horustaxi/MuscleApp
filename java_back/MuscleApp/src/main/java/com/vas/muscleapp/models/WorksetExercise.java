package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "workset_exercise")
public class WorksetExercise extends BaseEntity implements Serializable {

	@Column(name = "series_number", nullable = false, length = 50)
	private String seriesNumber;
	@Column(name = "repetitions_number", nullable = false, length = 50)
	private String repetitionsNumber;
	// in seconds
	@Column(name = "resting_time")
	private Short restingTime;
	@Lob
	@Column(name = "details", length = 200)
	private String details;

	@OneToOne
	private Exercise exercise;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Workset workset;

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(getId());
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
		if (!(obj instanceof WorksetExercise)) {
			return false;
		}
		final WorksetExercise other = (WorksetExercise) obj;
		return Objects.equals(getId(), other.getId());
	}

}
