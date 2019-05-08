package com.vas.muscleapp.models;

import com.vas.muscleapp.enums.Language;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Vinícius
 */
@Entity(name = "muscle_group")
public class MuscleGroup extends BaseEntity implements Serializable {

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;
    @Column(name = "language_for_localization", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language languageForLocalization;

    @OneToMany(mappedBy = "muscleGroup")
    private List<Muscle> muscles;

    public MuscleGroup() {
    }

    public MuscleGroup(String name, Language languageForLocalization) {
        this.name = name;
        this.languageForLocalization = languageForLocalization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase().trim();
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    public List<Muscle> getMuscles() {
        return muscles;
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
        if (!(obj instanceof MuscleGroup)) {
            return false;
        }
        final MuscleGroup other = (MuscleGroup) obj;
        return this.name.equalsIgnoreCase(other.name);
    }
}
