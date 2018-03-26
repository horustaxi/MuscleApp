package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vinícius
 */
@Entity
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String mainMuscle;
    private String secondaryMuscles;
    @Column(length = 500)
    private String description;

    public Exercise() {
    }

    public Exercise(String name, String mainMuscle, String secondaryMuscles, String description) {
        setName(name);
        setMainMuscle(mainMuscle);
        setSecondaryMuscles(secondaryMuscles);
        setDescription(description);
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

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name.toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 500) {
            throw new IllegalArgumentException("Description must hava a maximum of 500 characters");
        }
        this.description = description;
    }

    public String getMainMuscle() {
        return mainMuscle;
    }

    public void setMainMuscle(String mainMuscle) {
        if (mainMuscle.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.mainMuscle = mainMuscle.toLowerCase();
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(String secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles.toLowerCase();
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
        final Exercise other = (Exercise) obj;
        return this.name.equalsIgnoreCase(other.name);
    }
}
