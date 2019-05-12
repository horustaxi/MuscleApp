package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
@SuppressWarnings("serial")
@Entity(name = "muscle_group")
public class MuscleGroup extends BaseEntity implements Serializable {

	@Column(nullable = false, length = 50, unique = true)
	@NotEmpty
	private String name;
	@Column(name = "language_for_localization", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private Language languageForLocalization;

	@OneToMany(mappedBy = "muscleGroup", fetch = FetchType.LAZY)
	private Set<Muscle> muscles;

	public MuscleGroup() {
	}

	public MuscleGroup(String name, Language languageForLocalization) {
		this.name = name.toLowerCase().trim();
		this.languageForLocalization = languageForLocalization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase().trim();
	}

	public void setMuscles(Set<Muscle> muscles) {
		this.muscles = muscles;
	}

	public Set<Muscle> getMuscles() {
		return muscles;
	}

	public Language getLanguageForLocalization() {
		return languageForLocalization;
	}

	public void setLanguageForLocalization(Language languageForLocalization) {
		this.languageForLocalization = languageForLocalization;
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
		if (!(obj instanceof MuscleGroup)) {
			return false;
		}
		final MuscleGroup other = (MuscleGroup) obj;
		return this.name.equalsIgnoreCase(other.name);
	}
}
