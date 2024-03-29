package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PokemonEntity;
import com.example.demo.repository.PokemonRepository;

@RestController
@RequestMapping("/regist-pokemon")
public class PokemonRegisterController {

	@Autowired
	PokemonRepository pokemonRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PokemonEntity registPokemon(@RequestBody PokemonEntity pokemon) {
		PokemonEntity gettedPokemon = pokemonRepository.save(pokemon);
		return gettedPokemon;
	}
}
