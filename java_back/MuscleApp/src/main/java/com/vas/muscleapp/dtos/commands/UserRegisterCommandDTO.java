package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Getter
@Setter
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

}
