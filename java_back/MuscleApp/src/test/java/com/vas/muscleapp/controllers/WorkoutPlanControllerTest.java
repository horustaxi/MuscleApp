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
import com.vas.muscleapp.dtos.WorkoutPlanDTO;
import com.vas.muscleapp.models.WorkoutPlan;
import com.vas.muscleapp.repositories.WorkoutPlanRepository;

public class WorkoutPlanControllerTest extends BaseControllerTest {

	@Autowired
	private WorkoutPlanRepository workoutPlanRepository;

	@Test
	public void WorkoutPlan_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/workout-plan")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) workoutPlanRepository.count()))).andReturn();

		List<WorkoutPlan> workoutPlans = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(workoutPlans.isEmpty());
	}

	@Test
	public void WorkoutPlan_GetById_ShouldReturnHttpOk() throws Exception {
		WorkoutPlan workoutPlanRequested = workoutPlanRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/workout-plan/" + workoutPlanRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		WorkoutPlanDTO workoutPlan = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), WorkoutPlanDTO.class);
		assertEquals(workoutPlanRequested.getDescription(), workoutPlan.getDescription());
		assertEquals(workoutPlanRequested.getId(), workoutPlan.getId());
		assertEquals(workoutPlanRequested.getCreatedBy().getName(), workoutPlan.getCreatedByName());
		assertEquals(workoutPlanRequested.getCreatedBy().getId(), workoutPlan.getCreatedById());
		assertEquals(workoutPlanRequested.getCreatedBy().getName(), workoutPlan.getCreatedToName());
		assertEquals(workoutPlanRequested.getCreatedTo().getId(), workoutPlan.getCreatedToId());
	}

}
