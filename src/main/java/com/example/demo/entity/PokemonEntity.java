package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pokemon")
@Data
public class PokemonEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

}
