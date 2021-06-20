package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.PokedexForm;
import com.example.demo.form.ValidateResultForm;
import com.example.demo.service.FormCheckService;
import com.example.demo.service.RegistPokedexService;

@RestController
@RequestMapping("/regist-pokedex")
public class PokedexValidaterController {

	@Autowired
	FormCheckService fcService;
	
	@Autowired
	RegistPokedexService rpService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ValidateResultForm registPokemon(@Validated @RequestBody PokedexForm pokedexForm, BindingResult result) {

		ValidateResultForm vrForm = fcService.getFormCheckResult(result);
		if (!vrForm.isOk()) {
			return vrForm;
		}
		rpService.regist(pokedexForm);
		return vrForm;
	}
}
