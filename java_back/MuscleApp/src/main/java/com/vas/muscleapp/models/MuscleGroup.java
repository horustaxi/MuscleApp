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

	public MuscleGroup(String name, Language languageForLocalization) {
		this.name = name.toLowerCase().trim();
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
