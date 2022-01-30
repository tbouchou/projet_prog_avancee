package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entity.*;

/**
 * Servlet implementation class MeteoServlet
 */
public class MeteoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeteoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss= request.getSession();
		try {
		String ville = (String)request.getParameter("ville_txt");
		ss.setAttribute("ville", ville);
			Account compte = (Account)ss.getAttribute("compte");
			WeatherReport wR = (WeatherReport)new WeatherReport(ville,compte);
			Place place = (Place)wR.getPlace();
			ss.setAttribute("place", place);
			String imgURL = (String)wR.getImgURL();
			ss.setAttribute("imgURL", imgURL);
			response.sendRedirect("meteoAffichage.jsp?ville="+ville);
		}
		catch (IllegalArgumentException e) {
			response.sendRedirect("meteoAffichage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
