package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
public class MuscleGroupCreateCommandDTO {

	@NotEmpty
	@Size(max = 50)
	private String name;
	private Language languageForLocalization;

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
