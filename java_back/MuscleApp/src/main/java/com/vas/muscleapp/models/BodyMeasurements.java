package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "body_measurements")
public class BodyMeasurements extends BaseEntity
		implements Comparable<BodyMeasurements>, Serializable {

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

	@JsonIgnore
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User measuredUser;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User personalTrainnerUser;

	public BodyMeasurements(Builder builder) {
		this.age = builder.age;
		this.height = builder.height;
		this.weight = builder.weight;
		this.shoulders = builder.shoulders;
		this.chest = builder.chest;
		this.waist = builder.waist;
		this.rightArm = builder.rightArm;
		this.leftArm = builder.leftArm;
		this.rightForearm = builder.rightForearm;
		this.leftForearm = builder.leftForearm;
		this.rightThigh = builder.rightThigh;
		this.leftThigh = builder.leftThigh;
		this.rightCalf = builder.rightCalf;
		this.leftCalf = builder.leftCalf;
		this.glutes = builder.glutes;
		this.measuredUser = builder.measuredUser;
		this.personalTrainnerUser = builder.personalTrainnerUser;
	}

	@Override
	public int compareTo(BodyMeasurements o) {
		if (o == null) {
			return 1;
		}
		return getCreatedAt().compareTo(o.getCreatedAt());
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(getId());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BodyMeasurements)) {
			return false;
		}
		final BodyMeasurements other = (BodyMeasurements) obj;
		return Objects.equals(getId(), other.getId());
	}

	public static class Builder {

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
		private final User measuredUser;
		private final User personalTrainnerUser;

		public Builder(User measuredUser, User personalTrainnerUser) {
			this.measuredUser = measuredUser;
			this.personalTrainnerUser = personalTrainnerUser;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setHeight(float height) {
			this.height = height;
			return this;
		}

		public Builder setWeight(float weight) {
			this.weight = weight;
			return this;
		}

		public Builder setShoulders(float shoulders) {
			this.shoulders = shoulders;
			return this;
		}

		public Builder setChest(float chest) {
			this.chest = chest;
			return this;
		}

		public Builder setWaist(float waist) {
			this.waist = waist;
			return this;
		}

		public Builder setRightArm(float rightArm) {
			this.rightArm = rightArm;
			return this;
		}

		public Builder setLeftArm(float leftArm) {
			this.leftArm = leftArm;
			return this;
		}

		public Builder setRightForearm(float rightForearm) {
			this.rightForearm = rightForearm;
			return this;
		}

		public Builder setLeftForearm(float leftForearm) {
			this.leftForearm = leftForearm;
			return this;
		}

		public Builder setRightThigh(float rightThigh) {
			this.rightThigh = rightThigh;
			return this;
		}

		public Builder setLeftThigh(float leftThigh) {
			this.leftThigh = leftThigh;
			return this;
		}

		public Builder setRightCalf(float rightCalf) {
			this.rightCalf = rightCalf;
			return this;
		}

		public Builder setLeftCalf(float leftCalf) {
			this.leftCalf = leftCalf;
			return this;
		}

		public Builder setGlutes(float glutes) {
			this.glutes = glutes;
			return this;
		}

		public BodyMeasurements build() {
			return new BodyMeasurements(this);
		}

	}
}
