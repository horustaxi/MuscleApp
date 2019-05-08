package com.vas.muscleapp.models;

import com.vas.muscleapp.enums.Language;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Vinícius
 */
@Entity(name = "muscle")
public class Muscle extends BaseEntity implements Serializable {

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;
    @Column(name = "language_for_localization", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language languageForLocalization;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MuscleGroup muscleGroup;

    public Muscle() {
    }

    public Muscle(String name, MuscleGroup muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    public Muscle(String name, MuscleGroup muscleGroup, Language languageForLocalization) {
        this.name = name;
        this.languageForLocalization = languageForLocalization;
        this.muscleGroup = muscleGroup;
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
        this.name = name.toLowerCase().trim();
    }

    public Language getLanguageForLocalization() {
        return languageForLocalization;
    }

    public void setLanguageForLocalization(Language languageForLocalization) {
        this.languageForLocalization = languageForLocalization;
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
        if (!(obj instanceof Muscle)) {
            return false;
        }
        final Muscle other = (Muscle) obj;
        return this.name.equalsIgnoreCase(other.name);
    }
}
