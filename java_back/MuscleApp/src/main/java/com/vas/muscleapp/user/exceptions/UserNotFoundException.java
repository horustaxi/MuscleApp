/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.user.exceptions;

/**
 *
 * @author vinicius
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
    
}
