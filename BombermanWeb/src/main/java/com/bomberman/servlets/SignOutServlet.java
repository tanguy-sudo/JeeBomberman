package com.bomberman.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
/**
 * Gestion de la page SignOut(Déconnexion)
 * @author tanguy
 *
 */
public class SignOutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignOutServlet() {
        super();
    }

    /**
     * Gestion de la requête GET
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Déstruction de la session
		session.invalidate();
		// Redirection vers la page SignIn
		this.getServletContext().getRequestDispatcher("/WEB-INF/SignIn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
