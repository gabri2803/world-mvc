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
import it.objectmethod.worldmvc.dao.impl.CityDaoImpl;
import it.objectmethod.worldmvc.domain.City;

@WebServlet("/list-city")
public class ListCityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847265303904285215L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ICityDao cityDao = new CityDaoImpl();

		String countryCode = req.getParameter("code");

		List<City> list = new ArrayList<>();
		try {
			list = cityDao.getCitiesByCountryCode(countryCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("cityList", list);
		req.getRequestDispatcher("pages/show-list-cities.jsp").forward(req, resp);
	}

}
