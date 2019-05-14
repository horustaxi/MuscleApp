package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Entity(name = "exercise")
public class Exercise extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 50, unique = true)
	@NotEmpty
	private String name;
	@Column(length = 500)
	@Lob
	private String description;
	@Column(name = "language_for_localization", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private Language languageForLocalization;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Muscle> mainMuscles;
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Muscle> secondaryMuscles;

	public Exercise(String name, String description, Language languageForLocalization) {
		this.name = name.toLowerCase().trim();
		this.description = description;
		this.languageForLocalization = languageForLocalization;
	}

	public Set<Muscle> getMainMuscles() {
		if (mainMuscles == null) {
			mainMuscles = new HashSet<>();
		}
		return mainMuscles;
	}

	public Set<Muscle> getSecondaryMuscles() {
		if (secondaryMuscles == null) {
			secondaryMuscles = new HashSet<>();
		}
		return secondaryMuscles;
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
		if (!(obj instanceof Exception)) {
			return false;
		}
		final Exercise other = (Exercise) obj;
		return this.name.equalsIgnoreCase(other.name);
	}
}
