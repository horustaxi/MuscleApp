/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.dtos.UserDTO;
import com.vas.muscleapp.models.User;

/**
 *
 * @author vinicius
 */
public class UserControllerTest extends BaseControllerTest {

	@Test
	public void User_RegisterShouldReturnHttpCreated() throws Exception {
		User user = new User("Jack", "jack@email.com", "000000");
		mockMvc.perform(post("/register").contentType(contentType)
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isCreated());
	}

	@Test
	public void User_GetByEmail_ShoultReturnUserPlain() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/users?email=jack@email.com"))
				.andExpect(status().isOk()).andReturn();
		UserDTO user = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				UserDTO.class);
		assertEquals("Jack", user.getName());
		assertEquals("jack@email.com", user.getEmail());
	}

}
