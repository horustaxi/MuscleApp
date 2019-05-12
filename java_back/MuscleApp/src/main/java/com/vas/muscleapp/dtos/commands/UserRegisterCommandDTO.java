package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Vinicius
 */
public class UserRegisterCommandDTO {

	@NotEmpty
	@Length(max = 100)
	private String name;
	@NotEmpty
	@Length(max = 100)
	private String email;
	@NotEmpty
	@Size(min = 6, max = 100)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
