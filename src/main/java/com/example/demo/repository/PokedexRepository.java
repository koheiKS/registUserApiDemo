package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PokedexEntity;

public interface PokedexRepository extends CrudRepository<PokedexEntity, Integer> {
}
