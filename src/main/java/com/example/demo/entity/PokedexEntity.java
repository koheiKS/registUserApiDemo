package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pokedex")
@Data
public class PokedexEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	
	private String email;
	
	private String password;
}
