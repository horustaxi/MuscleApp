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
public class MuscleGroupQueryDTO {

	private Long id;
	private String name;
	private Language languageForLocalization;

}
