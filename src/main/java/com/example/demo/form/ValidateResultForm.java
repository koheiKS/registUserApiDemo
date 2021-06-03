package com.example.demo.form;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ValidateResultForm {

	private Map<String, String> errorMessages = new HashMap<String, String>();
}
