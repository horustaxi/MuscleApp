/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.Application;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.repositories.IExerciseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 *
 * @author vinicius
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ExerciseControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private MockMvc mockMvc;
    private HttpMessageConverter httpMessageConverter;
    
    private Exercise exercise1;
    private Exercise exercise2;
    private List<Exercise> exerciseList = new ArrayList<>();

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private IExerciseRepository exerciseRepository;

    @Autowired
    public void setConverters(HttpMessageConverter<?>[] converters) {
        this.httpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);
        assertNotNull("JSON message converter must not be null", this.httpMessageConverter);
    }

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        this.exerciseRepository.deleteAllInBatch();

        this.exercise1 = this.exerciseRepository.save(new Exercise("Squat", "Quadriceps", "Hamstrings, Gluteus, Hips",
                "Squat is a compound, full body exercise that trains primarily the muscles of the thighs, hips and buttocks, quadriceps femoris muscle (vastus lateralis, vastus medialis, vastus intermedius and rectus femoris), hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body"));
        this.exerciseList.add(exercise1);
        this.exercise2 = this.exerciseRepository.save(new Exercise("Leg press", "Quadriceps", "Gluteus",
                "leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs"));
        this.exerciseList.add(exercise2);
    }

    @Test
    public void testSave() {
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
}
