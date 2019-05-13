package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.vas.muscleapp.enums.Language;

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
@Entity(name = "muscle")
public class Muscle extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 50, unique = true)
	@NotEmpty
	private String name;
	@Column(name = "language_for_localization", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private Language languageForLocalization;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private MuscleGroup muscleGroup;

	public Muscle(String name, MuscleGroup muscleGroup, Language languageForLocalization) {
		this.name = name.toLowerCase().trim();
		this.languageForLocalization = languageForLocalization;
		this.muscleGroup = muscleGroup;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 13 * hash + Objects.hashCode(this.name);
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
		if (!(obj instanceof Muscle)) {
			return false;
		}
		final Muscle other = (Muscle) obj;
		return this.name.equalsIgnoreCase(other.name);
	}
}
