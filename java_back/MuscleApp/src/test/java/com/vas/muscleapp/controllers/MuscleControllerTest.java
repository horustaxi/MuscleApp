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
import com.vas.muscleapp.dtos.MuscleDTO;
import com.vas.muscleapp.models.Muscle;
import com.vas.muscleapp.repositories.MuscleRepository;

public class MuscleControllerTest extends BaseControllerTest {

	@Autowired
	private MuscleRepository muscleRepository;

	@Test
	public void Muscle_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/muscles")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) muscleRepository.count()))).andReturn();

		List<Muscle> muscles = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				List.class);
		assertFalse(muscles.isEmpty());
	}

	@Test
	public void Muscle_GetById_ShouldReturnHttpOk() throws Exception {
		Muscle muscleRequested = muscleRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc.perform(get("/muscles/" + muscleRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		MuscleDTO muscle = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				MuscleDTO.class);
		assertEquals(muscleRequested.getName(), muscle.getName());
	}

}
