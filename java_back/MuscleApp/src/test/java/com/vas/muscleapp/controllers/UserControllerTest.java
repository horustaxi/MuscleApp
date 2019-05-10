/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import com.vas.muscleapp.abstracts.BaseControllerTest;
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

}
