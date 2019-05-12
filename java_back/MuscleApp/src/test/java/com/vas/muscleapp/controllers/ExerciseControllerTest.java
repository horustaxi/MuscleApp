package com.vas.muscleapp.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.queries.ExerciseQueryDTO;
import com.vas.muscleapp.enums.Language;
import com.vas.muscleapp.models.Exercise;
import com.vas.muscleapp.repositories.ExerciseRepository;

/**
 *
 * @author vinicius
 */
public class ExerciseControllerTest extends BaseControllerTest {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Test
	public void Exercise_Save_ShouldReturnHttpCreated() throws IOException, Exception {
		Exercise exercise = new Exercise("test",
				"The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps",
				Language.ENGLISH);
		mockMvc.perform(post("/exercises").contentType(contentType)
				.content(objectMapper.writeValueAsString(exercise)))
				.andExpect(status().isCreated());
	}

	@Test
	public void Exercise_Save_ShouldReturnHttpConflict() throws Exception {
		Exercise exercise = new Exercise("Leg raise",
				"The bench press is an upper body strength training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as supporting chest, arm, and shoulder muscles such as the anterior deltoids, serratus anterior, coracobrachialis, scapulae fixers, trapezii, and the triceps",
				Language.ENGLISH);
		mockMvc.perform(post("/exercises").contentType(contentType)
				.content(objectMapper.writeValueAsString(exercise)))
				.andExpect(status().isConflict());
	}

	@Test
	public void Exercise_GetAll_ShouldReturnHttpOkAndAllExercises() throws Exception {
		mockMvc.perform(get("/exercises")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) exerciseRepository.count())));
	}

	@Test
	public void Exercise_GetById_ShouldReturnHttpOkAndOneExercises() throws Exception {
		Exercise exerciseRequested = exerciseRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc.perform(get("/exercises/" + exerciseRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();
		String responseBodyAsString = mvcResult.getResponse().getContentAsString();
		ExerciseQueryDTO exerciseDTO = objectMapper.readValue(responseBodyAsString, ExerciseQueryDTO.class);
		Assert.assertEquals(exerciseRequested.getName(), exerciseDTO.getName());
		Assert.assertEquals(exerciseRequested.getDescription(), exerciseDTO.getDescription());
	}
}
