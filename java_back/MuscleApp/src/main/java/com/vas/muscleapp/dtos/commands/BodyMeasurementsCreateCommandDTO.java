package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
public class BodyMeasurementsCreateCommandDTO {

	@Positive
	private int age;
	@Positive
	private float height;
	@Positive
	private float weight;
	@Positive
	private float shoulders;
	@Positive
	private float chest;
	@Positive
	private float waist;
	@Positive
	private float rightArm;
	@Positive
	private float leftArm;
	@Positive
	private float rightForearm;
	@Positive
	private float leftForearm;
	@Positive
	private float rightThigh;
	@Positive
	private float leftThigh;
	@Positive
	private float rightCalf;
	@Positive
	private float leftCalf;
	@Positive
	private float glutes;

	private Long measuredUserId;
	private Long personalTrainnerUserId;

}
