/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vinícius
 */
public class WorksetExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String seriesNumber;
    private String repetitionsNumber;
    //in seconds
    private int restingTime;
    private float charge;
    //0 = Kg, 1= Lbs
    private int chargeUnit;
    
    Set<Exercise> exercises = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getRepetitionsNumber() {
        return repetitionsNumber;
    }

    public void setRepetitionsNumber(String repetitionsNumber) {
        this.repetitionsNumber = repetitionsNumber;
    }

    public int getRestingTime() {
        return restingTime;
    }

    public void setRestingTime(int restingTime) {
        this.restingTime = restingTime;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public int getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(int chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }
    
}
