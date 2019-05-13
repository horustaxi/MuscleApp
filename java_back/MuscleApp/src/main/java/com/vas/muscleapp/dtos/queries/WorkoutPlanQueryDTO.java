package com.vas.muscleapp.dtos.queries;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class WorkoutPlanQueryDTO {

	private Long id;
	private String description;
	private String createdByName;
	private Long createdById;
	private Long createdToId;
	private String createdToName;

}
