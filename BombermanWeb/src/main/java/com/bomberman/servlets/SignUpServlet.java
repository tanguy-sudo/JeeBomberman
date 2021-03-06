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
import com.bomberman.forms.SignUpForm;
import com.bomberman.services.PlayService;
/**
 * Gestion de la page SignUp
 * @author tanguy guillaume
 *
 */
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
    }

    /**
     * Gestion de la requête GET
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		// Redirection vers la page Home si l'utilisateur existe
		if(Objects.nonNull(user)) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);	
		}

	}

	/**
	 * Gestion de la page POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		SignUpForm signupform  = new SignUpForm();
		// Création d'un utilisateur
		User user = signupform.createUser(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("userSession", user);

		if(Objects.nonNull(user)) {
			PlayService playService = new PlayService();
			// Récupération de ses parties(vide, car vient juste d'être crée)
			List<Play> plays = playService.getPlay(request);
			
			request.setAttribute("plays", plays);
			request.setAttribute("size", plays.size());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);					
		} else {
			Boolean errorConnect = true;
			request.setAttribute("errorConnect", errorConnect);
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);	
		}
	}

}
