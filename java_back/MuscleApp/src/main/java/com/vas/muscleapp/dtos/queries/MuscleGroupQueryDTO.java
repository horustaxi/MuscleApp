package com.vas.muscleapp.dtos.queries;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
public class MuscleGroupQueryDTO {

	private Long id;
	private String name;
	private Language languageForLocalization;

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

}
