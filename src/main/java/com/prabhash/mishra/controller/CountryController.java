package com.prabhash.mishra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prabhash.mishra.model.Country;
import com.prabhash.mishra.service.CountryService;



@RestController
@RequestMapping("/api/users")  
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/",method=RequestMethod.GET,headers= "Accept=application/json")
	public List<Country> getCountries(){
		List<Country> listOfCountries= countryService.getAllCountries();
		 return listOfCountries;
	}
	
	@RequestMapping(value="getCountry/{id}",method=RequestMethod.GET,headers="Accept=application/Json")
	public Country getCountryById(@PathVariable("id") int id){
		
		return countryService.getCountry(id);
	}
	
	@RequestMapping(value="/addCountry",method=RequestMethod.POST,headers="Accept=application/Json")
	public void addCountry(@RequestBody Country country){
		
		 countryService.addCountry(country);
	}
	
	@RequestMapping(value="/updateCountry/{id}",method=RequestMethod.PUT,headers="Accept=application/Json")
	public void updateCountry(@PathVariable("id") int id,@RequestBody Country country ){
		country.setId(id);
		
		countryService.updateCountry(country);
	}
	
	@RequestMapping(value="/deleteCountry/{id}",method=RequestMethod.DELETE,headers="Accept=application/Json")
	public void deleteCountry(@PathVariable("id") int id){
		
		countryService.deleteCountry(id);
	}

}
