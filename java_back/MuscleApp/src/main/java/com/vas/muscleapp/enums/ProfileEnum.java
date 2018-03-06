/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.enums;

/**
 *
 * @author Vinicius
 */
public enum ProfileEnum {
    Administrator(0), Simple(1), PersonalTrainner(2);
    public int profileValue;
    ProfileEnum(int valor) {
        profileValue = valor;
    }
}
