package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.vas.muscleapp.enums.Language;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class ExerciseCreateCommandDTO {

	@NotEmpty
	private String name;
	@Size(max = 500)
	private String description;
	private Language languageForLocalization;

}
