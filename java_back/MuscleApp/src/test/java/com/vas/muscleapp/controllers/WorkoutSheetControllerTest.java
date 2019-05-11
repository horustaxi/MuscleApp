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
import com.vas.muscleapp.dtos.WorkoutSheetDTO;
import com.vas.muscleapp.models.WorkoutSheet;
import com.vas.muscleapp.repositories.WorkoutPlanRepository;
import com.vas.muscleapp.repositories.WorkoutSheetRepository;

public class WorkoutSheetControllerTest extends BaseControllerTest {

	@Autowired
	private WorkoutSheetRepository workoutSheetRepository;
	@Autowired
	private WorkoutPlanRepository workoutPlanRepository;

	@Test
	public void WorkoutSheet_GetAllByWorkoutPlan_ShouldReturnHttpOkAndAllActives()
			throws Exception {
		Long workoutPlanId = workoutPlanRepository.findAll().get(0).getId();
		MvcResult mvcResult = mockMvc
				.perform(get("/workout-plan/" + workoutPlanId + "/workout-sheet"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) workoutSheetRepository.count())))
				.andReturn();

		List<WorkoutSheet> workoutSheets = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(workoutSheets.isEmpty());
	}

	@Test
	public void WorkoutSheet_GetById_ShouldReturnHttpOk() throws Exception {
		WorkoutSheet workoutSheetRequested = workoutSheetRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/workout-sheet/" + workoutSheetRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		WorkoutSheetDTO workoutSheet = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), WorkoutSheetDTO.class);
		assertEquals(workoutSheetRequested.getId(), workoutSheet.getId());
		assertEquals(workoutSheetRequested.getDescription(), workoutSheet.getDescription());
		assertEquals(workoutSheetRequested.getWorkoutPlan().getDescription(),
				workoutSheet.getWorkoutPlanDescription());
	}

}
