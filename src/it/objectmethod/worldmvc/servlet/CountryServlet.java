package it.objectmethod.worldmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.dao.impl.CountryDaoImpl;
import it.objectmethod.worldmvc.domain.Country;
@WebServlet("/country")
public class CountryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4493373630023901377L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String countryNameStr = req.getParameter("nameCountry");
		String countryContStr = req.getParameter("continentName");
		ICountryDao countryDao = new CountryDaoImpl();
		Country country = null;
		try {
			country = countryDao.getNation(countryNameStr, countryContStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("country", country);
		req.getRequestDispatcher("pages/show-country.jsp").forward(req, resp);
	}
}
