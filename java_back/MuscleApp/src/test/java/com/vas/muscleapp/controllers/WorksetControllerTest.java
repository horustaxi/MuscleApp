package com.vas.muscleapp.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.WorksetDTO;
import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.repositories.WorkoutSheetRepository;
import com.vas.muscleapp.repositories.WorksetRepository;

public class WorksetControllerTest extends BaseControllerTest {

	@Autowired
	private WorksetRepository worksetRepository;
	@Autowired
	private WorkoutSheetRepository workoutSheetRepository;

	@Test
	public void Workset_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		Long workoutSheetId = workoutSheetRepository.findAll().get(0).getId();
		MvcResult mvcResult = mockMvc.perform(get("/workout-sheet/" + workoutSheetId + "/workset"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) worksetRepository.count()))).andReturn();

		List<Workset> worksets = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(worksets.isEmpty());
	}

	@Test
	public void Workset_GetById_ShouldReturnHttpOk() throws Exception {
		Workset worksetRequested = worksetRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc.perform(get("/workset/" + worksetRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		WorksetDTO workset = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				WorksetDTO.class);
		assertEquals(worksetRequested.getId(), workset.getId());
		assertEquals(worksetRequested.getLetter(), workset.getLetter());
		assertEquals(worksetRequested.getWorkoutSheet().getDescription(),
				workset.getWorkoutSheetDescription());
	}

}
