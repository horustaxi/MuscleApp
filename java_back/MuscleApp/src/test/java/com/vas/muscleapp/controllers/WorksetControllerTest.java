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
import org.springframework.transaction.annotation.Transactional;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.queries.WorksetQueryDTO;
import com.vas.muscleapp.models.WorkoutSheet;
import com.vas.muscleapp.models.Workset;
import com.vas.muscleapp.repositories.WorkoutSheetRepository;
import com.vas.muscleapp.repositories.WorksetRepository;

@Transactional
public class WorksetControllerTest extends BaseControllerTest {

	@Autowired
	private WorksetRepository worksetRepository;
	@Autowired
	private WorkoutSheetRepository workoutSheetRepository;

	@Test
	public void Workset_GetAllByWorkoutSHeet_ShouldReturnHttpOkAndAllActives() throws Exception {
		WorkoutSheet workoutSheet = workoutSheetRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/workout-sheets/" + workoutSheet.getId() + "/worksets"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(workoutSheet.getWorksets().size()))).andReturn();

		List<WorksetQueryDTO> worksets = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(worksets.isEmpty());
	}

	@Test
	public void Workset_GetById_ShouldReturnHttpOk() throws Exception {
		Workset worksetRequested = worksetRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc.perform(get("/worksets/" + worksetRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		WorksetQueryDTO workset = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				WorksetQueryDTO.class);
		assertEquals(worksetRequested.getId(), workset.getId());
		assertEquals(worksetRequested.getLetter(), workset.getLetter());
		assertEquals(worksetRequested.getWorkoutSheet().getDescription(),
				workset.getWorkoutSheetDescription());
	}

}
