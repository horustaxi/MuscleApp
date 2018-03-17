package com.vas.muscleapp.user;

import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.WorkoutSheet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Vinicius
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private short type;
    
    @OneToMany(mappedBy = "measuredUser", cascade = CascadeType.ALL)
    private Set<BodyMeasurements> bodyMeasurementses = new HashSet<>();
    @OneToMany(mappedBy = "personalTrainnerUser", cascade = CascadeType.ALL)
    private Set<BodyMeasurements> bodyMeasurementsesCreateds = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<WorkoutSheet> workoutSheets = new HashSet<>();

    public User() {
    }    

    public User(String name, String email, String password, short type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
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
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public void setBodyMeasurementses(Set<BodyMeasurements> bodyMeasurementses) {
        this.bodyMeasurementses = bodyMeasurementses;
    }

    public Set<BodyMeasurements> getBodyMeasurementses() {
        return bodyMeasurementses;
    }

    public void setWorkoutSheets(Set<WorkoutSheet> workoutSheets) {
        this.workoutSheets = workoutSheets;
    }

    public Set<WorkoutSheet> getWorkoutSheets() {
        return workoutSheets;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.email, other.email);
    }

}
