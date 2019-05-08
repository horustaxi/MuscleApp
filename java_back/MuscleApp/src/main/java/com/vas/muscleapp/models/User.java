package com.vas.muscleapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Vinicius
 */
@Entity
public class User extends BaseEntity implements Serializable {

    @Column(nullable = false)
    @NotEmpty
    private String name;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String email;
    @Column(nullable = false)
    @NotEmpty
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "measuredUser", cascade = CascadeType.ALL)
    private List<BodyMeasurements> bodyMeasurementses = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "personalTrainnerUser", cascade = CascadeType.ALL)
    private Set<BodyMeasurements> bodyMeasurementsesCreateds = new HashSet<>();
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private final Set<WorkoutPlan> workoutPlansCreated = new HashSet<>();
    @OneToMany(mappedBy = "createdTo", cascade = CascadeType.ALL)
    private Set<WorkoutPlan> workoutPlans = new HashSet<>();

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        boolean ok = email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        if (!ok) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must have at least 6 characters");
        }
        this.password = password;
    }

    public void setBodyMeasurementses(List<BodyMeasurements> bodyMeasurementses) {
        this.bodyMeasurementses = bodyMeasurementses;
    }

    public List<BodyMeasurements> getBodyMeasurementses() {
        return bodyMeasurementses;
    }

    public void setWorkoutPlans(Set<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    public Set<WorkoutPlan> getWorkoutPlansCreated() {
        return workoutPlansCreated;
    }

    public Set<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void setBodyMeasurementsesCreateds(Set<BodyMeasurements> bodyMeasurementsesCreateds) {
        this.bodyMeasurementsesCreateds = bodyMeasurementsesCreateds;
    }

    public Set<BodyMeasurements> getBodyMeasurementsesCreateds() {
        return bodyMeasurementsesCreateds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
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
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.email, other.email);
    }

}
