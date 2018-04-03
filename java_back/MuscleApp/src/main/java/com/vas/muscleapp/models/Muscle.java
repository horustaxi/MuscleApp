package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vinícius
 */
@Entity
public class Muscle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MuscleGroup muscleGroup;

    public Muscle() {
    }

    public Muscle(String name, MuscleGroup muscleGroup) {
        setName(name);
        this.muscleGroup = muscleGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
<<<<<<< HEAD
        this.name = name.toLowerCase().trim();
=======
        this.name = name.toLowerCase();
>>>>>>> a42f0a67fa7d8049dfd206237da7ad70b52b53d8
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.name);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Muscle other = (Muscle) obj;
        return this.name.equalsIgnoreCase(other.name);
    }
}
