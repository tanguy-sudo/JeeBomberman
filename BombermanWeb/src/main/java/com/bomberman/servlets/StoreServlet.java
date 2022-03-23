package com.bomberman.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

import com.bomberman.beans.User;
import com.bomberman.forms.StoreForm;

/**
 * Gestion de la page Store
 * @author tanguy
 *
 */
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreServlet() {
        super();
    }

    /**
     * Gestion de la requête GET
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		//Vérifie que l'utilisateur existe
		if(Objects.nonNull(user)) {
			// Récupération de la couleur de l'agent
			request.setAttribute("color_agent", user.getCouleur_agent());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Store.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignIn.jsp").forward(request, response);	
		}
	}

	/**
	 * Gestion de la requête POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreForm storeForm = new StoreForm();
		// Mise à jour de la couleur
		User user = storeForm.UpdateColorAgent(request);
		if(Objects.nonNull(user)) {
			request.setAttribute("color_agent", user.getCouleur_agent());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Store.jsp").forward(request, response);
	}

}
