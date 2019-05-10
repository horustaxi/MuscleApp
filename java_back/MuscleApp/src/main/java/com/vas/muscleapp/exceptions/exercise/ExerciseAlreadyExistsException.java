/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.exceptions.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author vinicius
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ExerciseAlreadyExistsException extends RuntimeException {

	public ExerciseAlreadyExistsException(String name) {
		super("Exercise with name '" + name + "' already exists.");
	}

}
