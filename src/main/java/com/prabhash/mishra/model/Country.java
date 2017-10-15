package com.prabhash.mishra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * This is our model class that corresponds to country table in database
 */

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="countryName")
	String countryName;
	
	@Column(name="population")
	long population;
	
	public Country(){
		super();
	}
	
	public Country(int id,String countryName,long population){
		
		this.id=id;
		this.countryName=countryName;
		this.population=population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
	
	

}
