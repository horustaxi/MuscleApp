package com.vas.muscleapp.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Vinícius
 */
@Entity
public class Workset {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private char letter;
    @OneToMany(mappedBy = "workset", cascade = CascadeType.ALL) 
    private Set<WorksetExercise> worksetExercises = new HashSet<>();
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private WorkoutSheet workoutSheet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Set<WorksetExercise> getWorksetExercises() {
        return worksetExercises;
    }

    public void setWorksetExercises(Set<WorksetExercise> worksetExercises) {
        this.worksetExercises = worksetExercises;
    }

    public void setWorkoutSheet(WorkoutSheet workoutSheet) {
        this.workoutSheet = workoutSheet;
    }

    public WorkoutSheet getWorkoutSheet() {
        return workoutSheet;
    }
    
}
