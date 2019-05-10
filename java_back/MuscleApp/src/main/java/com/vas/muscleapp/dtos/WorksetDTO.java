package com.vas.muscleapp.dtos;

/**
 *
 * @author Vinícius
 */
public class WorksetDTO {

	private Long id;
	private char letter;
	private String workoutSheetDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public String getWorkoutSheetDescription() {
		return workoutSheetDescription;
	}

	public void setWorkoutSheetDescription(String workoutSheetDescription) {
		this.workoutSheetDescription = workoutSheetDescription;
	}

}
