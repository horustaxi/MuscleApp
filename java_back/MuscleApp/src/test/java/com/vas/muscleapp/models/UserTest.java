/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.models;

import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Vinícius
 */
public class UserTest {
    User user;
    
    @Before
    public void setUp() {
        user = new User();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetPasswordWithException() throws Exception {
        user.setPassword("1234");
    }
    
    @Test
    public void testSetPassword() throws Exception {
        user.setPassword("123456");
        user.setPassword("1234567");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailWithException1() {
        user.setEmail("a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailWithException12() {
        user.setEmail("a@");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailWithException13() {
        user.setEmail("a@a");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailWithException14() {
        user.setEmail("email@email,com");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEmailWithException15() {
        user.setEmail("ema,il@email.com");
    }
    
    @Test
    public void testSetEmail() {
        user.setEmail("email@email.com");
    }
    
}
