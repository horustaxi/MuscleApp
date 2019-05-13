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
public class MuscleQueryDTO {

	private Long id;
	private String name;
	private String muscleGroupName;
	private Language languageForLocalization;

}
