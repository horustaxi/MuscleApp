/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.models;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vinícius
 */
public class ExerciseTest {

	Exercise exercise;

	@Before
	public void setUp() {
		exercise = new Exercise();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNameWithException() {
		exercise.setName("");
	}

	@Test
	public void testSetName() throws Exception {
		exercise.setName("Bench Press");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDescriptionWithException() {
		exercise.setDescription(
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu ");
	}

	@Test
	public void testSetDescription() {
		exercise.setDescription(
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu");
	}

}
