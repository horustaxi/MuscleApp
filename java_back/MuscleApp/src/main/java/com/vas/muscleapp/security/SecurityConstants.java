/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vas.muscleapp.security;

/**
 *
 * @author Vinícius
 */
public class SecurityConstants {
	public static String SECRET = "askSA3sklj46afRRTRUSAHuHFG767frbu343SAbwYTYhdbahdGFGjsjdbdahjdrHYTYIYEe6aiusa6hih67uhuh";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/register";
	public static final String SIGN_IN_URL = "/login";
}
