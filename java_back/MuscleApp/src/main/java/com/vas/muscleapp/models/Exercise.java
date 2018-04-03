package com.vas.muscleapp.models;

import com.vas.muscleapp.enums.Language;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
    @ManyToMany
    private List<Muscle> mainMuscles;
    @ManyToMany
    private List<Muscle> secondaryMuscles;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Language language;

    public Exercise() {
    }

    public Exercise(String name, String description, Language language) {
        setName(name);
        setDescription(description);
        this.language = language;
        this.mainMuscles = new ArrayList<>();
        this.secondaryMuscles = new ArrayList<>();
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
        this.name = name.toLowerCase().trim();
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

    public void setMainMuscles(List<Muscle> mainMuscles) {
        this.mainMuscles = mainMuscles;
    }

    public List<Muscle> getMainMuscles() {
        return mainMuscles;
    }

    public void setSecondaryMuscles(List<Muscle> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public List<Muscle> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
