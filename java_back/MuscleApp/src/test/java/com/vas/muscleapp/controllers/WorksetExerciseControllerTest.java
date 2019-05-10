package com.vas.muscleapp.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.WorksetExerciseDTO;
import com.vas.muscleapp.models.WorksetExercise;
import com.vas.muscleapp.repositories.WorksetExerciseRepository;

public class WorksetExerciseControllerTest extends BaseControllerTest {

	@Autowired
	private WorksetExerciseRepository worksetExerciseRepository;

	@Test
	public void WorksetExercise_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/workset-exercise")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) worksetExerciseRepository.count())))
				.andReturn();

		List<WorksetExercise> worksetExercises = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(worksetExercises.isEmpty());
	}

	@Test
	public void WorksetExercise_GetById_ShouldReturnHttpOk() throws Exception {
		WorksetExercise worksetExerciseRequested = worksetExerciseRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/workset-exercise/" + worksetExerciseRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		WorksetExerciseDTO worksetExercise = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), WorksetExerciseDTO.class);
		assertEquals(worksetExerciseRequested.getId(), worksetExercise.getId());
		assertEquals(worksetExerciseRequested.getDetails(), worksetExercise.getDetails());
		assertEquals(worksetExerciseRequested.getExercise().getName(),
				worksetExercise.getExerciseName());
		assertEquals(worksetExerciseRequested.getRepetitionsNumber(),
				worksetExercise.getRepetitionsNumber());
		assertEquals(worksetExerciseRequested.getSeriesNumber(), worksetExercise.getSeriesNumber());
		assertTrue(worksetExerciseRequested.getRestingTime() == worksetExercise.getRestingTime());
		assertEquals(worksetExerciseRequested.getWorkset().getLetter(),
				worksetExercise.getWorksetLetter());
	}

}
