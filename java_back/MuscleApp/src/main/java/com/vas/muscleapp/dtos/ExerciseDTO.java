package com.vas.muscleapp.dtos;

import com.vas.muscleapp.enums.Language;

/**
 *
 * @author Vinícius
 */
public class ExerciseDTO {

    private Long id;
    private String name;
    private String description;
    private Language languageForLocalization;

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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguageForLocalization() {
        return languageForLocalization;
    }

    public void setLanguageForLocalization(Language languageForLocalization) {
        this.languageForLocalization = languageForLocalization;
    }

}
