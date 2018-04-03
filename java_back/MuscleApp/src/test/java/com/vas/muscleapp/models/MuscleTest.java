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
public class MuscleTest {

    Muscle muscle;

    @Before
    public void setUp() {
        muscle = new Muscle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMainMuscleWithException() {
        muscle.setName("");
    }

    @Test
    public void testSetMainMuscle() {
        muscle.setName("Triceps");
    }

}
