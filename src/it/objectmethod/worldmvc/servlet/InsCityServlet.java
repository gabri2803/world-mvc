package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
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

@WebServlet("/insert")
public class InsCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 467264393261790677L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICountryDao countryDao = new CountryDaoImpl();
		ICityDao cityDao = new CityDaoImpl();

		int id = Integer.parseInt(req.getParameter("id"));

		List<Country> list = null;
		City city = null;
		if (id > -1) {
			city = cityDao.getCityById(id);
		}
		list = countryDao.getAllCountry();
		req.setAttribute("city", city);
		req.setAttribute("countryList", list);
		req.getRequestDispatcher("pages/edit-city.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICityDao cityDao = new CityDaoImpl();
		String idCity = req.getParameter("idCity");
		String name = req.getParameter("name");
		String countryCode = req.getParameter("code");
		String district = req.getParameter("dist");
		int population = Integer.valueOf(req.getParameter("pop"));
		if (idCity != "") {
			int id = Integer.parseInt(idCity);
			cityDao.putCity(id, name, countryCode, district, population);
		} else {
			cityDao.postNewCity(name, countryCode, district, population);
		}
		req.setAttribute("message", "Salvato con successo");
		req.getRequestDispatcher("/list-city?code=" + countryCode).forward(req, resp);
	}
}
