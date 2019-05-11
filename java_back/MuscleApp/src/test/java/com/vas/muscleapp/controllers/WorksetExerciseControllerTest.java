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
import org.springframework.transaction.annotation.Transactional;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.WorksetExerciseDTO;
import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.models.WorksetExercise;
import com.vas.muscleapp.repositories.WorksetExerciseRepository;
import com.vas.muscleapp.repositories.WorksetRepository;

@Transactional
public class WorksetExerciseControllerTest extends BaseControllerTest {

	@Autowired
	private WorksetExerciseRepository worksetExerciseRepository;
	@Autowired
	private WorksetRepository worksetRepository;

	@Test
	public void WorksetExercise_GetAllByWorkset_ShouldReturnHttpOk() throws Exception {
		Workset workset = worksetRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/workset/" + workset.getId() + "/workset-exercise"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(workset.getWorksetExercises().size())))
				.andReturn();

		List<WorksetExerciseDTO> worksetExercises = objectMapper
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
