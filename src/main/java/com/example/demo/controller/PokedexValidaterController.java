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
import com.example.demo.service.PokedexFormCheckService;

@RestController
@RequestMapping("/regist-pokedex")
public class PokedexValidaterController {

	@Autowired
	PokedexFormCheckService pfcService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void registPokemon(@Validated @RequestBody PokedexForm pokedexForm, BindingResult result) {

		pfcService.getPokedexCheckResult(pokedexForm, result);
	}
}
