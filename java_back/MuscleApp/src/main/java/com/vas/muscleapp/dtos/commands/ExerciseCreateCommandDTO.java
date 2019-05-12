package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
public class ExerciseCreateCommandDTO {

	@NotEmpty
	private String name;
	@Size(max = 500)
	private String description;
	private Language languageForLocalization;

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

	public void setLanguageForLocalization(Language languageForLocalization) {
		this.languageForLocalization = languageForLocalization;
	}

	public Language getLanguageForLocalization() {
		return languageForLocalization;
	}

}
