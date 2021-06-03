package com.example.demo.form;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PokedexForm {

	@Size(min = 2, max= 10)
	private String name;

	private String email;

	private String password;

	private String confirmPassword;

}
