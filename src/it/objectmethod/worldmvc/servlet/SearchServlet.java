package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICityDao;
import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.dao.impl.CountryDaoImpl;
import it.objectmethod.worldmvc.domain.City;
import it.objectmethod.worldmvc.domain.Country;

@WebServlet("/search-by")
public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5798378769156300709L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Country> list = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		try {
			list = countryDao.getAllCountry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("country", list);

		ICityDao cityDao = new CityDaoImpl();
		List<City> city = new ArrayList<>();
		String cityName = req.getParameter("name");
		String country = req.getParameter("country");
		try {
			city = cityDao.getCityByNameOrByCountry(cityName, country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("city", city);
		req.getRequestDispatcher("pages/search-city.jsp").forward(req, resp);
	}

}
