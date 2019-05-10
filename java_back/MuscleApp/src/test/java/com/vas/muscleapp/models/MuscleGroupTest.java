package com.vas.muscleapp.models;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vinícius
 */
public class MuscleGroupTest {

	MuscleGroup muscleGroup;

	@Before
	public void setUp() {
		muscleGroup = new MuscleGroup();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMainMuscleWithException() {
		muscleGroup.setName("");
	}

	@Test
	public void testSetMainMuscle() {
		muscleGroup.setName("Triceps");
	}

}
