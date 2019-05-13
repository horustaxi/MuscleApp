package com.vas.muscleapp.dtos.queries;

import com.vas.muscleapp.enums.Language;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class ExerciseQueryDTO {

	private Long id;
	private String name;
	private String description;
	private Language languageForLocalization;

}
