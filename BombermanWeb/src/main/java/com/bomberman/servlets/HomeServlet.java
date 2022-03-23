package com.bomberman.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.bomberman.beans.Play;
import com.bomberman.beans.User;
import com.bomberman.services.PlayService;

/**
 * Gestion de la page Home
 * @author tanguy
 *
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

    /**
     * Gestion de la requête GET
     * Regarde si une session existe avant de le rediriger vers la page Home
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		// Regarde si une session existe
		if(Objects.nonNull(user)) {
			PlayService playService = new PlayService();
			// Récupère sa liste de partie jouée
			List<Play> plays = playService.getPlay(request);
			
			request.setAttribute("plays", plays);
			request.setAttribute("size", plays.size());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignIn.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
