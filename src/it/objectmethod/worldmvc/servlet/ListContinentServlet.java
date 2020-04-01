package it.objectmethod.worldmvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.worldmvc.dao.ICountryDao;
import it.objectmethod.worldmvc.dao.impl.CountryDaoImpl;

@WebServlet("/continent-list")
public class ListContinentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038547980256213345L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();
		try {
			list = countryDao.getAllContinent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("continent", list);
		req.getRequestDispatcher("pages/show-list.jsp").forward(req, resp);
	}
}
