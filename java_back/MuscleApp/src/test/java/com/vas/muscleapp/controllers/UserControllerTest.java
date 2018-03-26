/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.controllers;

import com.vas.muscleapp.abstracts.BaseControllerTest;
import com.vas.muscleapp.models.User;
import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author vinicius
 */
public class UserControllerTest extends BaseControllerTest {
    @Test
    public void testRegister() throws Exception {
        User user = new User("Jack", "jack@email.com", "000000");
        mockMvc.perform(post("/register").contentType(contentType).content(json(user)))
                .andExpect(status().isCreated());
    }

}
