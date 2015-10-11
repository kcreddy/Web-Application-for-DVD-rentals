package com.dvd.customer;

import film_search.filmBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class customer_film_checkbox
 */
@WebServlet("/customer_film_checkbox")
public class customer_film_checkbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customer_film_checkbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String custId=request.getParameter("custId");
		System.out.println("Customer id in servlet"+custId);
		List<filmBeans> filmBeanList=new ArrayList<filmBeans>();
		filmBeans fBean=null;
		String[] selectedFilms=request.getParameterValues("selectedFilms");
		
		for(int i=0;i<selectedFilms.length;i++){
			System.out.println(selectedFilms[i]);
			fBean=new filmBeans();
			String[] FilmsSplit=selectedFilms[i].split("\\|");
		fBean.settitle(FilmsSplit[0]);
		fBean.setrating(FilmsSplit[1]);
		fBean.setrelease_year(Integer.parseInt(FilmsSplit[2]));
		fBean.setrental_duration(Integer.parseInt(FilmsSplit[3]));
		fBean.setprice(Integer.parseInt(FilmsSplit[4]));
		fBean.setreplacement_cost(Integer.parseInt(FilmsSplit[5]));
		fBean.setavailability(Integer.parseInt(FilmsSplit[6]));
		fBean.setlanguage(FilmsSplit[7]);
			filmBeanList.add(fBean);
		}
		//boolean insert=customer_film_order.insertFilmOrder(filmBeanList,custId);
		RequestDispatcher dispatcher=null;
		request.setAttribute("custId", custId);
		request.setAttribute("selectedFilms", selectedFilms);
		dispatcher = request.getRequestDispatcher("reviewOrder.jsp");
	
		dispatcher.forward(request, response); 

	
	}

}
