package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.Positive;

/**
 *
 * @author Vinícius
 */
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getShoulders() {
		return shoulders;
	}

	public void setShoulders(float shoulders) {
		this.shoulders = shoulders;
	}

	public float getChest() {
		return chest;
	}

	public void setChest(float chest) {
		this.chest = chest;
	}

	public float getWaist() {
		return waist;
	}

	public void setWaist(float waist) {
		this.waist = waist;
	}

	public float getRightArm() {
		return rightArm;
	}

	public void setRightArm(float rightArm) {
		this.rightArm = rightArm;
	}

	public float getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(float leftArm) {
		this.leftArm = leftArm;
	}

	public float getRightForearm() {
		return rightForearm;
	}

	public void setRightForearm(float rightForearm) {
		this.rightForearm = rightForearm;
	}

	public float getLeftForearm() {
		return leftForearm;
	}

	public void setLeftForearm(float leftForearm) {
		this.leftForearm = leftForearm;
	}

	public float getRightThigh() {
		return rightThigh;
	}

	public void setRightThigh(float rightThigh) {
		this.rightThigh = rightThigh;
	}

	public float getLeftThigh() {
		return leftThigh;
	}

	public void setLeftThigh(float leftThigh) {
		this.leftThigh = leftThigh;
	}

	public float getRightCalf() {
		return rightCalf;
	}

	public void setRightCalf(float rightCalf) {
		this.rightCalf = rightCalf;
	}

	public float getLeftCalf() {
		return leftCalf;
	}

	public void setLeftCalf(float leftCalf) {
		this.leftCalf = leftCalf;
	}

	public float getGlutes() {
		return glutes;
	}

	public void setGlutes(float glutes) {
		this.glutes = glutes;
	}

	public Long getMeasuredUserId() {
		return measuredUserId;
	}

	public void setMeasuredUserId(Long measuredUserId) {
		this.measuredUserId = measuredUserId;
	}

	public Long getPersonalTrainnerUserId() {
		return personalTrainnerUserId;
	}

	public void setPersonalTrainnerUserId(Long personalTrainnerUserId) {
		this.personalTrainnerUserId = personalTrainnerUserId;
	}

}
