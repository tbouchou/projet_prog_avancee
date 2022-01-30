package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import datatypes.*;
import entity.Account;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = (String)request.getParameter("idP");
		String motDeP = (String)request.getParameter("pwd");
		HttpSession ss= request.getSession();
		try {
			LoginType login = new LoginType (identifiant);
			PasswordType pwd = new PasswordType(motDeP);
			ss.setAttribute("id", login);
			ss.setAttribute("pwd", pwd);
			if (Account.chercherCompte(login, pwd)==true) {
				Account acc = Account.getCompte(login, pwd);
				ss.setAttribute("compte", acc);
				response.sendRedirect("meteoAffichage.jsp?id="+ss.getAttribute("id"));
				System.out.println("compte existant");
			}
			else {
				Account acc = new Account (login,pwd);
				ss.setAttribute("compte", acc);
				response.sendRedirect("meteoAffichage.jsp");
				System.out.println("nouveau compte");
			}
			System.out.println(Account.getAccountList());
			
		}
		catch (IllegalArgumentException e) {
			ss.setAttribute("erreur", e.getMessage());
			System.out.println(e.getMessage());
			response.sendRedirect("login.jsp");
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
