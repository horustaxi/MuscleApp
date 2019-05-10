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
import com.vas.muscleapp.dtos.BodyMeasurementsDTO;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;

public class BodyMeasurementsControllerTest extends BaseControllerTest {

	@Autowired
	private BodyMeasurementsRepository bodyMeasurementsRepository;

	@Test
	public void BodyMeasurements_GetAll_ShouldReturnHttpOkAndAllActives() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/body-measurements")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize((int) bodyMeasurementsRepository.count())))
				.andReturn();

		List<BodyMeasurements> bodyMeasurementss = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), List.class);
		assertFalse(bodyMeasurementss.isEmpty());
	}

	@Test
	public void BodyMeasurements_GetById_ShouldReturnHttpOk() throws Exception {
		BodyMeasurements bodyMeasurementsRequested = bodyMeasurementsRepository.findAll().get(0);
		MvcResult mvcResult = mockMvc
				.perform(get("/body-measurements/" + bodyMeasurementsRequested.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andReturn();

		BodyMeasurementsDTO bodyMeasurements = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), BodyMeasurementsDTO.class);
		assertEquals(bodyMeasurementsRequested.getAge(), bodyMeasurements.getAge());
		assertEquals(bodyMeasurementsRequested.getChest(), bodyMeasurements.getChest(), 0);
		assertEquals(bodyMeasurementsRequested.getGlutes(), bodyMeasurements.getGlutes(), 0);
		assertEquals(bodyMeasurementsRequested.getHeight(), bodyMeasurements.getHeight(), 0);
		assertEquals(bodyMeasurementsRequested.getRightArm(), bodyMeasurements.getRightArm(), 0);
	}

}
