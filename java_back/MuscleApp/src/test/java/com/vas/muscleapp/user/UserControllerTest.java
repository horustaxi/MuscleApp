/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user;

import com.vas.muscleapp.abstracts.AbstractControllerTest;
import com.vas.muscleapp.bodyMeasurements.BodyMeasurements;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author vinicius
 */
public class UserControllerTest extends AbstractControllerTest {

    private User user1;
    private User user2;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        this.userRepository.deleteAllInBatch();
        
        user2 = userRepository.save(new User("Edson Costa", "edson.costa@gmail.com", "123456"));
        user1 = new User("Tiago da Silva", "tiago.silva@gmail.com", "123456");
        BodyMeasurements bodyMeasurements = new BodyMeasurements.BodyMeasurementsBuilder(user1, user2)
                .setAge(27)
                .setChest(76)
                .setGlutes(80)
                .setHeight(179)
                .setLeftArm(34)
                .setRightArm(34.5f)
                .setLeftCalf(32.3f)
                .setRightCalf(32.7f)
                .setLeftForearm(25.2f)
                .setRightForearm(25)
                .setLeftThigh(47)
                .setRightThigh(47.8f)
                .setShoulders(94.6f)
                .setWaist(80)
                .setWeight(70)
                .buildPerson();
        BodyMeasurements bodyMeasurements2 = new BodyMeasurements.BodyMeasurementsBuilder(user1, user2)
                .setAge(28)
                .setChest(80)
                .setGlutes(82)
                .setHeight(179)
                .setLeftArm(36)
                .setRightArm(36.5f)
                .setLeftCalf(34.3f)
                .setRightCalf(34.7f)
                .setLeftForearm(27.2f)
                .setRightForearm(27)
                .setLeftThigh(50)
                .setRightThigh(50.8f)
                .setShoulders(98.6f)
                .setWaist(83)
                .setWeight(74)
                .buildPerson();
        user1.getBodyMeasurementses().add(bodyMeasurements);
        user1.getBodyMeasurementses().add(bodyMeasurements2);
        userRepository.save(user1);
    }

    @Test
    public void testRegister() throws Exception {
        User user = new User("Jack", "jack@email.com", "000000");
        mockMvc.perform(post("/register").contentType(contentType).content(json(user)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetBodyMeasurements() throws Exception {
        mockMvc.perform(get("/user/"+user1.getId()+"/bodymeasurements"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(this.user1.getBodyMeasurementses().get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].age", is("27")))
                .andExpect(jsonPath("$[1].id", is(this.user1.getBodyMeasurementses().get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].age", is("28")));
    }

}
