///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.vas.muscleapp.controllers;
//
//import com.vas.muscleapp.abstracts.BaseControllerTest;
//import com.vas.muscleapp.models.BodyMeasurements;
//import com.vas.muscleapp.models.User;
//import com.vas.muscleapp.services.UserService;
//import java.io.IOException;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
///**
// *
// * @author Vinícius
// */
//public class BodyMeasurementsControllerTest extends BaseControllerTest {
//    
//    private User user1;
//    private User user2;
//    private BodyMeasurements bodyMeasurements1;
//    private BodyMeasurements bodyMeasurements2;
//
//    @Autowired
//    private UserService userService;
//
//    @Before
//    public void setUp() throws Exception {
//        this.userService.deleteAll();
//        
//        user2 = userService.save(new User("Edson Costa", "edson.costa@gmail.com", "123456"));
//        user1 = new User("Tiago da Silva", "tiago.silva@gmail.com", "123456");
//        bodyMeasurements1 = new BodyMeasurements.BodyMeasurementsBuilder(user1, user2)
//                .setAge(27)
//                .setChest(76)
//                .setGlutes(80)
//                .setHeight(179)
//                .setLeftArm(34)
//                .setRightArm(34.5f)
//                .setLeftCalf(32.3f)
//                .setRightCalf(32.7f)
//                .setLeftForearm(25.2f)
//                .setRightForearm(25)
//                .setLeftThigh(47)
//                .setRightThigh(47.8f)
//                .setShoulders(94.6f)
//                .setWaist(80)
//                .setWeight(70)
//                .buildBodyMeasurements();
//        bodyMeasurements2 = new BodyMeasurements.BodyMeasurementsBuilder(user1, user2)
//                .setAge(28)
//                .setChest(80)
//                .setGlutes(82)
//                .setHeight(179)
//                .setLeftArm(36)
//                .setRightArm(36.5f)
//                .setLeftCalf(34.3f)
//                .setRightCalf(34.7f)
//                .setLeftForearm(27.2f)
//                .setRightForearm(27)
//                .setLeftThigh(50)
//                .setRightThigh(50.8f)
//                .setShoulders(98.6f)
//                .setWaist(83)
//                .setWeight(74)
//                .buildBodyMeasurements();
//        user1.getBodyMeasurementses().add(bodyMeasurements1);
//        user1.getBodyMeasurementses().add(bodyMeasurements2);
//        userService.save(user1);
//    }
//
//    @Test
//    public void testGetBodyMeasurements() throws Exception {
//        mockMvc.perform(get("/user/"+user1.getId()+"/bodymeasurements"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(this.user1.getBodyMeasurementses().get(0).getId().intValue())))
//                .andExpect(jsonPath("$[0].age", is(27)))
//                .andExpect(jsonPath("$[1].id", is(this.user1.getBodyMeasurementses().get(1).getId().intValue())))
//                .andExpect(jsonPath("$[1].age", is(28)));
//    }
//
//    @Test
//    public void testGetBodyMeasurementsWithException() throws Exception {
//        mockMvc.perform(get("/user/"+24234+"/bodymeasurements"))
//                .andExpect(status().isNotFound());
//    }
//    
//    @Test
//    public void testSave() throws IOException, Exception {
//        BodyMeasurements bodyMeasurements = new BodyMeasurements.BodyMeasurementsBuilder(null, null)
//                .setAge(28)
//                .setChest(80)
//                .setGlutes(82)
//                .setHeight(179)
//                .setLeftArm(36)
//                .setRightArm(36.5f)
//                .setLeftCalf(34.3f)
//                .setRightCalf(34.7f)
//                .setLeftForearm(27.2f)
//                .setRightForearm(27)
//                .setLeftThigh(50)
//                .setRightThigh(50.8f)
//                .setShoulders(98.6f)
//                .setWaist(83)
//                .setWeight(74)
//                .buildBodyMeasurements();
//        User personal = new User();
//        personal.setId(user2.getId());
//        bodyMeasurements.setPersonalTrainnerUser(personal);
//        User user = new User();
//        personal.setId(user1.getId());
//        bodyMeasurements.setPersonalTrainnerUser(user);
//        mockMvc.perform(post("/user/"+user1.getId()+"/bodymeasurements").contentType(contentType).content(json(bodyMeasurements)))
//                .andExpect(status().isCreated());
//    }
//    
//}
