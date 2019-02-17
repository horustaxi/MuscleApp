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
public class WorkoutPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false)
    private String description;
    @Column(nullable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User createdBy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User createdTo;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
    private final Set<WorkoutSheet> workoutSheets = new HashSet<>();

    public WorkoutPlan() {
    }

    public WorkoutPlan(String description) {
        setDescription(description);
    }

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
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.description = description.toLowerCase().trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedTo(User createdTo) {
        this.createdTo = createdTo;
    }

    public User getCreatedTo() {
        return createdTo;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<WorkoutSheet> getWorkoutSheets() {
        return workoutSheets;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        if (!(obj instanceof WorkoutPlan)) {
            return false;
        }
        final WorkoutPlan other = (WorkoutPlan) obj;
        return Objects.equals(this.id, other.id);
    }
}
