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
import com.vas.muscleapp.dtos.MuscleGroupDTO;
import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.repositories.MuscleGroupRepository;

public class MuscleGroupControllerTest extends BaseControllerTest {

	@Autowired
	private MuscleGroupRepository muscleGroupRepository;

	@Test
	public void MuscleGroup_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/muscle-group")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) muscleGroupRepository.count()))).andReturn();

		List<MuscleGroup> muscleGroups = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(muscleGroups.isEmpty());
	}

	@Test
	public void MuscleGroup_GetById_ShouldReturnHttpOk() throws Exception {
		MuscleGroup muscleGroupRequested = muscleGroupRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/muscle-group/" + muscleGroupRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		MuscleGroupDTO muscleGroup = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), MuscleGroupDTO.class);
		assertEquals(muscleGroupRequested.getMuscles(), muscleGroup.getName());
		assertEquals(muscleGroupRequested.getId(), muscleGroup.getId());
	}

}
