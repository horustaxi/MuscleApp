package com.vas.muscleapp.dtos.queries;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */

@Getter
@Setter
public class BodyMeasurementsCreateDTO {

	private int age;
	private float height;
	private float weight;
	private float shoulders;
	private float chest;
	private float waist;
	private float rightArm;
	private float leftArm;
	private float rightForearm;
	private float leftForearm;
	private float rightThigh;
	private float leftThigh;
	private float rightCalf;
	private float leftCalf;
	private float glutes;

	private Long measuredUserId;
	private Long personalTrainnerUserId;

}
