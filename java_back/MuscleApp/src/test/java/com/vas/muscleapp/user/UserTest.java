/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user;

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
    
}
