package com.vas.muscleapp.dtos.queries;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class WorksetExerciseQueryDTO {

	private Long id;
	private String seriesNumber;
	private String repetitionsNumber;
	// in seconds
	private Short restingTime;
	private String details;
	private String exerciseName;
	private char worksetLetter;

}
