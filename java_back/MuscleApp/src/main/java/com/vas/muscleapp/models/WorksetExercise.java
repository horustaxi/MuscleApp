package com.vas.muscleapp.models;

import java.util.Objects;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        if (!(obj instanceof WorksetExercise)) {
            return false;
        }
        final WorksetExercise other = (WorksetExercise) obj;
        return Objects.equals(this.id, other.id);
    }

}
