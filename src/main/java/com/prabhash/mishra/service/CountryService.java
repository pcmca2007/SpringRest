package com.prabhash.mishra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prabhash.mishra.dao.CountryDAO;
import com.prabhash.mishra.model.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryDAO countryDao;

	@Transactional
	public List<Country> getAllCountries() {
		
		return countryDao.getAllCountries();
	}

	@Transactional
	public Country getCountry(int id) {
		// TODO Auto-generated method stub
		return countryDao.getCountry(id);
	}

	public void addCountry(Country country) {
		
		countryDao.addCountry(country);
	}

	public void updateCountry(Country country) {
		
		countryDao.updateCountry(country);
	}

	public void deleteCountry(int id) {
		
		countryDao.deleteCountry(id);
	}

}
