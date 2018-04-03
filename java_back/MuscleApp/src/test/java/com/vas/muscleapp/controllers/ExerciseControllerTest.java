/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.enums.Language;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.services.ExerciseService;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author vinicius
 */
public class ExerciseControllerTest extends BaseControllerTest {
    
    private Exercise exercise1;
    private Exercise exercise2;
    private final List<Exercise> exerciseList = new ArrayList<>();

    @Autowired
    private ExerciseService exerciseService;

    @Before
    public void setUp() {
        this.exerciseService.deleteAllInBatch();

        this.exercise1 = this.exerciseService.save(new Exercise("Crunch", "The crunch is performed while lying face up on the floor with knees bent, by curling the shoulders up towards the pelvis. This is an isolation exercise for the abdominals", Language.ENGLISH));
        this.exerciseList.add(exercise1);
        this.exercise2 = this.exerciseService.save(new Exercise("leg raise", "The leg raise is performed while sitting on a bench or flat on the floor by raising the knees towards the shoulders, or legs to a vertical upright position. This is a compound exercise that also involves the hip flexors", Language.ENGLISH));
        this.exerciseList.add(exercise2);
    }

    @Test
    public void testSave() throws IOException, Exception {
        Exercise exercise = new Exercise("Bench press",
                "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps",
                Language.ENGLISH);
        mockMvc.perform(post("/exercises").contentType(contentType).content(json(exercise)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testSaveWithConflict() throws Exception {
        Exercise exercise = new Exercise("Leg raise",
                "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps",
                Language.ENGLISH);
        mockMvc.perform(post("/exercises").contentType(contentType).content(json(exercise)))
                .andExpect(status().isConflict());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/exercises"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.exerciseList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].name", is("crunch")))
                .andExpect(jsonPath("$[1].id", is(this.exerciseList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].name", is("leg raise")));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/exercises/"+this.exerciseList.get(1).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.exercise2.getId().intValue())))
                .andExpect(jsonPath("$.name", is("leg raise")));
    }
}
