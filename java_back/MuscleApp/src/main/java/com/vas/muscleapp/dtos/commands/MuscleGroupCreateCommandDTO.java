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
public class MuscleGroupCreateCommandDTO {

	@NotEmpty
	@Size(max = 50)
	private String name;
	private Language languageForLocalization;

}
