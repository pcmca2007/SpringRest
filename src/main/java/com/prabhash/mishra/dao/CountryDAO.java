package com.prabhash.mishra.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prabhash.mishra.model.Country;

@Repository

public class CountryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Country> getAllCountries() {
		Session session= this.sessionFactory.getCurrentSession();
		List<Country> countryList= session.createQuery("from Country").list();
		return countryList;
	}

	public Country getCountry(int id) {
		Session session= this.sessionFactory.openSession();
		Country country= (Country) session.get(Country.class, new Integer(id));
		return country;
	}

	public void addCountry(Country country) {
		//Session session;
		//try{
		Session session= this.sessionFactory.openSession();
		
		//}catch(HibernateException e){
			
			// session= sessionFactory.openSession();
		//}
		
		//System.out.println("before persist--------********"+country.getPopulation()+" "+country);
		session.save(country);
		
	}

	public void updateCountry(Country country) {
		Session session= this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
				
		if(country.getId() > 0){
			
		System.out.println("Inside");
			session.update(country);
		}
		tx.commit();
		session.close();
	}

	public void deleteCountry(int id) {
		Session session= this.sessionFactory.openSession();
		
		org.hibernate.Transaction tx= session.beginTransaction();
		
		Country country= (Country)session.get(Country.class, new Integer(id));
		
		if(country !=null)
			session.delete(country);
		
		tx.commit();
		session.close();
		
	}

}
