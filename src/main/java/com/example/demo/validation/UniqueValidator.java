package com.example.demo.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.example.demo.annotation.Unique;
import com.example.demo.entity.PokedexEntity;
import com.example.demo.entity.PokemonEntity;
import com.example.demo.repository.PokedexRepository;
import com.example.demo.repository.PokemonRepository;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	@Autowired
	PokedexRepository pokedexRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;

	private String field;

	private List<Object> dbObjects;

	private String message;

	public void initialize(Unique constraintAnnotation) {
		field = constraintAnnotation.field();
		String repositoryName = constraintAnnotation.repositoryName();
		dbObjects = getDbObjects(repositoryName);
		message = constraintAnnotation.message();
	}

	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper beanWrapperValue = new BeanWrapperImpl(value);
        Object fieldValue = beanWrapperValue.getPropertyValue(field);
		boolean isUniqued = true;
		
		// DBから得たデータと一致するかを確かめる
		for (Object dbObject : dbObjects) {
			if (!isUniqued) {
				break;
			}
			BeanWrapper beanWrapperDbObject = new BeanWrapperImpl(dbObject);
			Object dbObjectValue = beanWrapperDbObject.getPropertyValue(field);
			isUniqued = !ObjectUtils.nullSafeEquals(fieldValue, dbObjectValue);
		}
		if (isUniqued) {
			return true;
		} else {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
			return false;
		}
	}
	
	// リポジトリ名からデータを全件取得しているので効率は良くない。
	// リポジトリ名+フィールド名からデータを検索できればもっと良いかも
	private List<Object> getDbObjects(String repositoryName) {
		List<Object> dbObjects = new ArrayList<Object>();
		switch (repositoryName) {
		case "PokedexRepository":
			Iterable<PokedexEntity> pokedexes = pokedexRepository.findAll();
			for (PokedexEntity pokedex : pokedexes) {
				Object dbObject = (Object) pokedex;
				dbObjects.add(dbObject);
			}
			break;
		case "PokemonRepository":
			Iterable<PokemonEntity> pokemons = pokemonRepository.findAll();
			for (PokemonEntity pokemon : pokemons) {
				Object dbObject = (Object) pokemon;
				dbObjects.add(dbObject);
			}
			break;
		}
		return dbObjects;
	}
}
