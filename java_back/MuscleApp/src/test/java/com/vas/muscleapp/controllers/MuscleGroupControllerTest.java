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
import com.vas.muscleapp.dtos.queries.MuscleGroupQueryDTO;
import com.vas.muscleapp.models.MuscleGroup;
import com.vas.muscleapp.repositories.MuscleGroupRepository;

@Transactional
public class MuscleGroupControllerTest extends BaseControllerTest {

	@Autowired
	private MuscleGroupRepository muscleGroupRepository;

	@Test
	public void MuscleGroup_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/muscle-groups")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) muscleGroupRepository.findAll().stream()
						.filter(mg -> mg.isActive()).count())))
				.andReturn();

		List<MuscleGroupQueryDTO> muscleGroups = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(muscleGroups.isEmpty());
	}

	@Test
	public void MuscleGroup_GetById_ShouldReturnHttpOk() throws Exception {
		MuscleGroup muscleGroupRequested = muscleGroupRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc.perform(get("/muscle-groups/" + muscleGroupRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		MuscleGroupQueryDTO muscleGroup = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), MuscleGroupQueryDTO.class);
		assertEquals(muscleGroupRequested.getName(), muscleGroup.getName());
		assertEquals(muscleGroupRequested.getId(), muscleGroup.getId());
	}

}
