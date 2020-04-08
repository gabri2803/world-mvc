package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.dao.impl.CountryDaoImpl;
import it.objectmethod.worldmvc.domain.Country;

@WebServlet("/country-list")
public class ListCountryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3576827312609540860L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICountryDao countryDao = new CountryDaoImpl();
		HttpSession session = req.getSession();

		String nomeCont = req.getParameter("nameCont");
		if (nomeCont != null) {
			session.setAttribute("nameCont", nomeCont);
		} else {
			nomeCont = (String) session.getAttribute("nameCont");
		}

		List<Country> countryList = null;
		try {
			countryList = countryDao.getCountriesByContinent(nomeCont);

		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("countryList", countryList);
		req.getRequestDispatcher("pages/show-list-countries.jsp").forward(req, resp);

	}
}
