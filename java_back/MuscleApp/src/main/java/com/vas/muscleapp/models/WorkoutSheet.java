package com.vas.muscleapp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

/**
 *
 * @author Vinícius
 */
@Entity
public class WorkoutSheet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    private boolean active;
    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private WorkoutPlan workoutPlan;
    @OneToMany(mappedBy = "workoutSheet", cascade = CascadeType.ALL)
    private Set<Workset> worksets = new HashSet<>();

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setWorksets(Set<Workset> worksets) {
        this.worksets = worksets;
    }

    public Set<Workset> getWorksets() {
        return worksets;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        if (!(obj instanceof WorkoutSheet)) {
            return false;
        }
        final WorkoutSheet other = (WorkoutSheet) obj;
        return Objects.equals(this.id, other.id);
    }

}
