/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Vinícius
 */
//@Entity
public class Workset {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private char letter;
    @OneToMany(mappedBy = "workset", cascade = CascadeType.ALL) 
    Set<WorksetExercise> worksetExercises = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
}
