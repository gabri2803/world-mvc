package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.City;

public interface ICityDao {

	City getCityByName(String nameCity);

	List<City> getCitiesByCountryCode(String countryCode);

	List<City> getCityByNameOrByCountry(String cityName, String country);

	void postNewCity(String name, String countryCode, String district, int population);

	void putCity(int id, String name, String countryCode, String district, int population);

	City getCityById(int id);
}
