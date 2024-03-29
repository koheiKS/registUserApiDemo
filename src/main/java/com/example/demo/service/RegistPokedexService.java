package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PokedexEntity;
import com.example.demo.form.PokedexForm;
import com.example.demo.repository.PokedexRepository;

@Service
public class RegistPokedexService {

	@Autowired
	PokedexRepository pokedexRepository;
	
	@Autowired
	EncryptionService encryptionService;
	
	public void regist(PokedexForm pokedexForm) {
		PokedexEntity pokedex = this.getPokedex(pokedexForm);
		pokedexRepository.save(pokedex);
	}

	private PokedexEntity getPokedex(PokedexForm pokedexForm) {
		PokedexEntity pokedex = new PokedexEntity();
		pokedex.setName(pokedexForm.getName());
		pokedex.setEmail(pokedexForm.getEmail());
		String encryptedPassword = encryptionService.encrypt(pokedexForm.getPassword());
		pokedex.setPassword(encryptedPassword);
		return pokedex;
	}
}
