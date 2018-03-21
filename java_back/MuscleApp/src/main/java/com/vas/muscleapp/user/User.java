package com.vas.muscleapp.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vas.muscleapp.bodyMeasurements.BodyMeasurements;
import com.vas.muscleapp.workoutSheet.WorkoutSheet;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    
    @JsonIgnore
    @OneToMany(mappedBy = "measuredUser", cascade = CascadeType.ALL)
    private Set<BodyMeasurements> bodyMeasurementses = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "personalTrainnerUser", cascade = CascadeType.ALL)
    private Set<BodyMeasurements> bodyMeasurementsesCreateds = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<WorkoutSheet> workoutSheets = new HashSet<>();

    public User() {
    }    

    public User(String name, String email, String password) throws Exception {
        setName(name);
        setEmail(email);
        setPassword(password);
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

    // TODO verify email pattern (IllegalFormatException)
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password.length() < 6) throw new IllegalArgumentException("Password must have at least 6 characters");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
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
