package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PokemonEntity;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Integer> {
}
