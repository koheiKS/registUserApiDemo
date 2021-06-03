package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.form.PokedexForm;
import com.example.demo.form.ValidateResultForm;

@Service
public class PokedexFormCheckService {

	public ValidateResultForm getPokedexCheckResult(PokedexForm pokedex, BindingResult result) {
		ValidateResultForm validateResultForm = new ValidateResultForm();
		List<FieldError> ff = result.getFieldErrors();
		System.out.println(ff);

		return validateResultForm;
	}


	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Class: " + this.getClass().getCanonicalName() + "\n");
	    sb.append("Settings:\n");
	    for (Field field : this.getClass().getDeclaredFields()) {
	        try {
	            field.setAccessible(true);
	            sb.append(field.getName() + " = " + field.get(this) + "\n");
	        } catch (IllegalAccessException e) {
	            sb.append(field.getName() + " = " + "access denied\n");
	        }
	    }
	    return sb.toString();
	}
}
