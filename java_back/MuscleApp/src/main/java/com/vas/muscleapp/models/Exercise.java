package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
@SuppressWarnings("serial")
@Entity(name = "exercise")
public class Exercise extends BaseEntity implements Serializable {

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String name;
	@ManyToMany
	private Set<Muscle> mainMuscles;
	@ManyToMany
	private Set<Muscle> secondaryMuscles;
	@Column(length = 500)
	private String description;
	@Column(name = "language_for_localization", nullable = false)
	@Enumerated(EnumType.STRING)
	private Language languageForLocalization;

	public Exercise() {
	}

	public Exercise(String name, String description, Language languageForLocalization) {
		this.name = name.toLowerCase().trim();
		this.description = description;
		this.languageForLocalization = languageForLocalization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase().trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMainMuscles(Set<Muscle> mainMuscles) {
		this.mainMuscles = mainMuscles;
	}

	public Set<Muscle> getMainMuscles() {
		if (mainMuscles == null) {
			mainMuscles = new HashSet<>();
		}
		return mainMuscles;
	}

	public void setSecondaryMuscles(Set<Muscle> secondaryMuscles) {
		this.secondaryMuscles = secondaryMuscles;
	}

	public Set<Muscle> getSecondaryMuscles() {
		if (secondaryMuscles == null) {
			secondaryMuscles = new HashSet<>();
		}
		return secondaryMuscles;
	}

	public void setLanguageForLocalization(Language languageForLocalization) {
		this.languageForLocalization = languageForLocalization;
	}

	public Language getLanguageForLocalization() {
		return languageForLocalization;
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
