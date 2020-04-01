package it.objectmethod.worldmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.worldmvc.config.ConnectionFactory;
import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.domain.Country;

public class CountryDaoImpl implements ICountryDao {
	@Override
	public Country getNation(String nameNation, String nameCont) {
		Country country = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM country WHERE Name = ? AND Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nameNation);
			stmt.setString(2, nameCont);
			rs = stmt.executeQuery();
			while (rs.next()) {
				country = new Country();
				country.setCode(rs.getString("Code"));
				country.setName(rs.getString("Name"));
				country.setContinent(rs.getString("Continent"));
				country.setRegion(rs.getString("Region"));
				country.setSurfaceArea(rs.getDouble("SurfaceArea"));
				country.setIndepYear(rs.getInt("IndepYear"));
				country.setPopulation(rs.getInt("Population"));
				country.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
				country.setGnp(rs.getDouble("GNP"));
				country.setGnpOld(rs.getDouble("GNPOld"));
				country.setLocalName(rs.getString("LocalName"));
				country.setGovernmentForm(rs.getString("GovernmentForm"));
				country.setHeadOfState(rs.getString("HeadOfState"));
				country.setCapital(rs.getInt("Capital"));
				country.setSecondCode(rs.getString("Code2"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return country;
	}

	@Override
	public List<Country> getCountriesByContinent(String nameCont) {
		List<Country> country = new ArrayList<>();
		Country coun = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM country WHERE Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nameCont);
			rs = stmt.executeQuery();
			while (rs.next()) {
				coun = new Country();
				coun.setCode(rs.getString("Code"));
				coun.setName(rs.getString("Name"));
				coun.setContinent(rs.getString("Continent"));
				coun.setRegion(rs.getString("Region"));
				coun.setSurfaceArea(rs.getDouble("SurfaceArea"));
				coun.setIndepYear(rs.getInt("IndepYear"));
				coun.setPopulation(rs.getInt("Population"));
				coun.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
				coun.setGnp(rs.getDouble("GNP"));
				coun.setGnpOld(rs.getDouble("GNPOld"));
				coun.setLocalName(rs.getString("LocalName"));
				coun.setGovernmentForm(rs.getString("GovernmentForm"));
				coun.setHeadOfState(rs.getString("HeadOfState"));
				coun.setCapital(rs.getInt("Capital"));
				coun.setSecondCode(rs.getString("Code2"));
				country.add(coun);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return country;
	}

	@Override
	public List<String> getAllContinent() {
		List<String> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT DISTINCT country.Continent FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("Continent"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Country> getAllCountry() {
		List<Country> list = new ArrayList<>();
		Connection conn = null;
		Country coun = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM country";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				coun = new Country();
				coun.setCode(rs.getString("Code"));
				coun.setName(rs.getString("Name"));
				coun.setContinent(rs.getString("Continent"));
				coun.setRegion(rs.getString("Region"));
				coun.setSurfaceArea(rs.getDouble("SurfaceArea"));
				coun.setIndepYear(rs.getInt("IndepYear"));
				coun.setPopulation(rs.getInt("Population"));
				coun.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
				coun.setGnp(rs.getDouble("GNP"));
				coun.setGnpOld(rs.getDouble("GNPOld"));
				coun.setLocalName(rs.getString("LocalName"));
				coun.setGovernmentForm(rs.getString("GovernmentForm"));
				coun.setHeadOfState(rs.getString("HeadOfState"));
				coun.setCapital(rs.getInt("Capital"));
				coun.setSecondCode(rs.getString("Code2"));
				list.add(coun);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
}
