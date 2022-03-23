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
import com.bomberman.forms.SignInForm;
import com.bomberman.services.PlayService;
/**
 * Gestion de la page SingIn
 * @author tanguy
 *
 */
public class SignInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignInServlet() {
        super();
    }

    /**
     * Gestion de la requête GET
     * Redirection vers la page SignIn si aucune session sinon Home
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if(Objects.nonNull(user)) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignIn.jsp").forward(request, response);	
		}
	}

	/**
	 * Gestion de la requête POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignInForm form = new SignInForm();
		
		// Tentative de connexion
		User user = form.connectUser(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("userSession", user);

		if(Objects.nonNull(user)) {
			PlayService playService = new PlayService();
			// Récupération de ses parties
			List<Play> plays = playService.getPlay(request);
			
			request.setAttribute("plays", plays);
			request.setAttribute("size", plays.size());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);					
		} else {
			Boolean errorConnect = true;
			request.setAttribute("errorConnect", errorConnect);
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignIn.jsp").forward(request, response);	
		}		
	}

}
