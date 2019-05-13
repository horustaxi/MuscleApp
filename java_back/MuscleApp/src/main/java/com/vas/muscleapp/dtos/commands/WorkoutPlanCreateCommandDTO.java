package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class WorkoutPlanCreateCommandDTO {

	@NotEmpty
	@Size(max = 100)
	private String description;
	private Long createdByUserId;
	private Long createdToUserId;

}
