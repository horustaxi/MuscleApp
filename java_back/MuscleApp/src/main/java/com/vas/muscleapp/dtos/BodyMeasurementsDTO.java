/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.dtos;

import java.util.Date;

/**
 *
 * @author vinicius
 */
public class BodyMeasurementsDTO {
    
    private Long id;
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
    private UserDTO personalTrainnerUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

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

    public UserDTO getPersonalTrainnerUser() {
        return personalTrainnerUser;
    }

    public void setPersonalTrainnerUser(UserDTO personalTrainnerUser) {
        this.personalTrainnerUser = personalTrainnerUser;
    }
    
}
