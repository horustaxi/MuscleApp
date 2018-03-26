/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.services.ExerciseService;
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

        this.exercise1 = this.exerciseService.save(new Exercise("Squat", "Quadriceps", "Hamstrings, Gluteus, Hips",
                "Squat is a compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks, quadriceps femoris muscle (vastus lateralis, vastus medialis, vastus intermedius and rectus femoris), hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body"));
        this.exerciseList.add(exercise1);
        this.exercise2 = this.exerciseService.save(new Exercise("Leg press", "Quadriceps2", "Gluteus",
                "leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs"));
        this.exerciseList.add(exercise2);
    }

    @Test
    public void testSave() throws Exception {
        Exercise exercise = new Exercise("Bench press", "Pectorals", "Deltoids, Triceps", "The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps");
        mockMvc.perform(post("/exercises").contentType(contentType).content(json(exercise)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/exercises"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.exerciseList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].name", is("squat")))
                .andExpect(jsonPath("$[1].id", is(this.exerciseList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].name", is("leg press")));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/exercises/"+this.exerciseList.get(1).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.exercise2.getId().intValue())))
                .andExpect(jsonPath("$.name", is("leg press")));
    }
}
