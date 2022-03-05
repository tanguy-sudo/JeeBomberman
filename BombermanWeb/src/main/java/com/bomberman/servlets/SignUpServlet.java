package com.bomberman.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bomberman.beans.User;
import com.bomberman.forms.SignUpForm;

public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if(user != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);	
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		SignUpForm signupform  = new SignUpForm();
		User user = signupform.createUser(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("userSession", user);

		if(user != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);					
		} else {
			Boolean errorConnect = true;
			request.setAttribute("errorConnect", errorConnect);
			this.getServletContext().getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);	
		}
	}

}
