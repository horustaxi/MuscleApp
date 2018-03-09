/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Vinícius
 */
public class WorkoutSheet {
    int id;
    String description;
    boolean active;
    Date createdAt;
    Set<Workset> worksets = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setWorksets(Set<Workset> worksets) {
        this.worksets = worksets;
    }

    public Set<Workset> getWorksets() {
        return worksets;
    }
    
}
