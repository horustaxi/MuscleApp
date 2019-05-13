package com.vas.muscleapp.dtos.commands;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class WorksetCreateCommandDTO {

	private char letter;
	private Long workoutSheetId;

}
