package com.vas.muscleapp.worksetExercise;

import com.vas.muscleapp.workset.Workset;
import com.vas.muscleapp.exercise.Exercise;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Vinícius
 */
@Entity
public class WorksetExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String seriesNumber;
    private String repetitionsNumber;
    //in seconds
    private int restingTime;
    private float charge;
    //0 = Kg, 1= Lbs
    private int chargeUnit;
    
    @OneToOne
    Exercise exercise;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Workset workset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }
    
}