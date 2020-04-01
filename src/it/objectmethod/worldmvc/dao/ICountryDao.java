package it.objectmethod.worldmvc.dao;

import java.util.List;

import it.objectmethod.worldmvc.domain.Country;

public interface ICountryDao {
	Country getNation(String nameNation, String nameCont);

	List<Country> getCountriesByContinent(String nameCont);

	List<String> getAllContinent();

	List<Country> getAllCountry();

}
