package com.vas.muscleapp.dtos.commands;

/**
 *
 * @author Vinícius
 */
public class WorksetCreateCommandDTO {

	private char letter;
	private Long workoutSheetId;

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public Long getWorkoutSheetId() {
		return workoutSheetId;
	}

	public void setWorkoutSheetId(Long workoutSheetId) {
		this.workoutSheetId = workoutSheetId;
	}

}
