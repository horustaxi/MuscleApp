package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Vinícius
 */
@Entity(name = "workset_exercise")
public class WorksetExercise extends BaseEntity implements Serializable {

    @Column(name = "series_number", nullable = false)
    private String seriesNumber;
    @Column(name = "repetitions_number", nullable = false)
    private String repetitionsNumber;
    //in seconds
    @Column(name = "resting_time")
    private Short restingTime;
    @Column(name = "details")
    private String details;

    @OneToOne
    Exercise exercise;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Workset workset;

    public WorksetExercise() {
    }

    public WorksetExercise(String seriesNumber, String repetitionsNumber, Short restingTime, String details, Exercise exercise, Workset workset) {
        this.seriesNumber = seriesNumber;
        this.repetitionsNumber = repetitionsNumber;
        this.restingTime = restingTime;
        this.details = details;
        this.exercise = exercise;
        this.workset = workset;
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

    public void setRestingTime(Short restingTime) {
        this.restingTime = restingTime;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Workset getWorkset() {
        return workset;
    }

    public void setWorkset(Workset workset) {
        this.workset = workset;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(getId());
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
        return Objects.equals(getId(), other.getId());
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
