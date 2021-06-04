package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PokedexForm {

	@NotEmpty
	@Size(min = 1, max= 10)
	private String name;

	@Size(min = 5, max = 255)
	private String email;

	@Size(min = 8, max = 255)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	@Size(min = 8, max = 255)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String confirmPassword;

}
