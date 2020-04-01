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

@WebServlet("/insert")
public class InsCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 467264393261790677L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Country> list = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		ICityDao cityDao = new CityDaoImpl();
		int id = Integer.valueOf(req.getParameter("id"));
		if (id > -1) {
			City city = cityDao.getCityById(id);
			req.setAttribute("city", city);
		}
		list = countryDao.getAllCountry();
		req.setAttribute("country", list);
		req.getRequestDispatcher("pages/insMod.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICityDao cityDao = new CityDaoImpl();
		String nameCity = req.getParameter("cityName");
		if (nameCity == null) {
			String name = req.getParameter("name");
			String countryCode = req.getParameter("code");
			String district = req.getParameter("dist");
			int population = Integer.valueOf(req.getParameter("pop"));
			cityDao.postNewCity(name, countryCode, district, population);
			req.getRequestDispatcher("/list-city?code=" + countryCode).forward(req, resp);
		} else {
			int idCity = Integer.valueOf(req.getParameter("idCity"));
			String name = req.getParameter("name");
			String countryCode = req.getParameter("code");
			String district = req.getParameter("dist");
			int population = Integer.valueOf(req.getParameter("pop"));
			cityDao.putCity(idCity, name, countryCode, district, population);
			req.getRequestDispatcher("/list-city?code=" + countryCode).forward(req, resp);
		}
	}
}
