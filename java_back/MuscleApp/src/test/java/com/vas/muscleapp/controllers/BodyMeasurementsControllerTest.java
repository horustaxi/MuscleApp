package com.vas.muscleapp.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.queries.BodyMeasurementsQueryDTO;
import com.vas.muscleapp.models.BodyMeasurements;
import com.vas.muscleapp.models.User;
import com.vas.muscleapp.repositories.BodyMeasurementsRepository;
import com.vas.muscleapp.repositories.UserRepository;

@Transactional
public class BodyMeasurementsControllerTest extends BaseControllerTest {

	@Autowired
	private BodyMeasurementsRepository bodyMeasurementsRepository;
	@Autowired
	private UserRepository userRepository;

	@Test
	public void BodyMeasurements_GetAllByUser_ShouldReturnHttpOkAndAll() throws Exception {
		User user = userRepository.findUserByEmail("tiago.oliveira@gmail.com").get();
		MvcResult mvcResult = mockMvc.perform(get("/users/" + user.getId() + "/body-measurements"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(user.getBodyMeasurements().size()))).andReturn();

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

		BodyMeasurementsQueryDTO bodyMeasurements = objectMapper
				.readValue(mvcResult.getResponse().getContentAsString(), BodyMeasurementsQueryDTO.class);
		assertEquals(bodyMeasurementsRequested.getAge(), bodyMeasurements.getAge());
		assertEquals(bodyMeasurementsRequested.getChest(), bodyMeasurements.getChest(), 0);
		assertEquals(bodyMeasurementsRequested.getGlutes(), bodyMeasurements.getGlutes(), 0);
		assertEquals(bodyMeasurementsRequested.getHeight(), bodyMeasurements.getHeight(), 0);
		assertEquals(bodyMeasurementsRequested.getRightArm(), bodyMeasurements.getRightArm(), 0);
	}

	@Test
	public void BodyMeasurements_Create_ShouldReturnCreated() throws Exception {
		User personalTrainnerUser = userRepository.findAll().get(0);
		User measuredUser = userRepository.findAll().get(1);
		BodyMeasurements bodyMeasurements = new BodyMeasurements.Builder(measuredUser,
				personalTrainnerUser).setAge(24)
						.setChest(95.3f)
						.build();
		mockMvc.perform(post("/users/" + measuredUser.getId() + "/body-measurements")
				.contentType(contentType)
				.content(objectMapper.writeValueAsString(bodyMeasurements)))
				.andExpect(status().isCreated());
	}

}
