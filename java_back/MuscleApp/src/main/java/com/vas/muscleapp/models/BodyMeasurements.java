package com.vas.muscleapp.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Vinícius
 */
@Entity
public class BodyMeasurements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
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
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User measuredUser;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User personalTrainnerUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
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

    public User getMeasuredUsuario() {
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
}
