package com.vas.muscleapp.bodyMeasurements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vas.muscleapp.user.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

/**
 *
 * @author Vinícius
 */
@Entity
public class BodyMeasurements implements Comparable<BodyMeasurements> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
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
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User measuredUser;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User personalTrainnerUser;

    public BodyMeasurements(int age, float height, float weight, float shoulders, float chest, float waist, float rightArm, float leftArm, float rightForearm, float leftForearm, float rightThigh, float leftThigh, float rightCalf, float leftCalf, float glutes, User measuredUser, User personalTrainnerUser) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.shoulders = shoulders;
        this.chest = chest;
        this.waist = waist;
        this.rightArm = rightArm;
        this.leftArm = leftArm;
        this.rightForearm = rightForearm;
        this.leftForearm = leftForearm;
        this.rightThigh = rightThigh;
        this.leftThigh = leftThigh;
        this.rightCalf = rightCalf;
        this.leftCalf = leftCalf;
        this.glutes = glutes;
        this.measuredUser = measuredUser;
        this.personalTrainnerUser = personalTrainnerUser;
    }

    public BodyMeasurements() {
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
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

    public void setPersonalTrainnerUser(User personalTrainnerUser) {
        this.personalTrainnerUser = personalTrainnerUser;
    }

    public void setMeasuredUser(User measuredUser) {
        this.measuredUser = measuredUser;
    }

    public User getPersonalTrainnerUser() {
        return personalTrainnerUser;
    }

    public User getMeasuredUser() {
        return measuredUser;
    }

    public void setGlutes(float glutes) {
        this.glutes = glutes;
    }

    public float getGlutes() {
        return glutes;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(BodyMeasurements o) {
        if (o == null && this == null) return 1;
        if (o == null) return 1;
        if (this == null) return -1;
        return this.createdAt.compareTo(o.getCreatedAt());
    }

    public static class BodyMeasurementsBuilder {

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

        public BodyMeasurementsBuilder(User measuredUser, User personalTrainnerUser) {
            this.measuredUser = measuredUser;
            this.personalTrainnerUser = personalTrainnerUser;
        }

        public BodyMeasurementsBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public BodyMeasurementsBuilder setHeight(float height) {
            this.height = height;
            return this;
        }

        public BodyMeasurementsBuilder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public BodyMeasurementsBuilder setShoulders(float shoulders) {
            this.shoulders = shoulders;
            return this;
        }

        public BodyMeasurementsBuilder setChest(float chest) {
            this.chest = chest;
            return this;
        }

        public BodyMeasurementsBuilder setWaist(float waist) {
            this.waist = waist;
            return this;
        }

        public BodyMeasurementsBuilder setRightArm(float rightArm) {
            this.rightArm = rightArm;
            return this;
        }

        public BodyMeasurementsBuilder setLeftArm(float leftArm) {
            this.leftArm = leftArm;
            return this;
        }

        public BodyMeasurementsBuilder setRightForearm(float rightForearm) {
            this.rightForearm = rightForearm;
            return this;
        }

        public BodyMeasurementsBuilder setLeftForearm(float leftForearm) {
            this.leftForearm = leftForearm;
            return this;
        }

        public BodyMeasurementsBuilder setRightThigh(float rightThigh) {
            this.rightThigh = rightThigh;
            return this;
        }

        public BodyMeasurementsBuilder setLeftThigh(float leftThigh) {
            this.leftThigh = leftThigh;
            return this;
        }

        public BodyMeasurementsBuilder setRightCalf(float rightCalf) {
            this.rightCalf = rightCalf;
            return this;
        }

        public BodyMeasurementsBuilder setLeftCalf(float leftCalf) {
            this.leftCalf = leftCalf;
            return this;
        }

        public BodyMeasurementsBuilder setGlutes(float glutes) {
            this.glutes = glutes;
            return this;
        }
        
        public BodyMeasurements buildPerson() {
            return new BodyMeasurements(age, height, weight, shoulders, chest, waist, rightArm, leftArm, rightForearm, leftForearm, rightThigh, leftThigh, rightCalf, leftCalf, glutes, measuredUser, personalTrainnerUser);
        }

    }
}
