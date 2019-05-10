package com.vas.muscleapp.dtos;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
public class MuscleDTO {

	private Long id;
	private String name;
	private Language languageForLocalization;
	private String muscleGroupName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getLanguageForLocalization() {
		return languageForLocalization;
	}

	public void setLanguageForLocalization(Language languageForLocalization) {
		this.languageForLocalization = languageForLocalization;
	}

	public String getMuscleGroupName() {
		return muscleGroupName;
	}

	public void setMuscleGroupName(String muscleGroupName) {
		this.muscleGroupName = muscleGroupName;
	}

}
