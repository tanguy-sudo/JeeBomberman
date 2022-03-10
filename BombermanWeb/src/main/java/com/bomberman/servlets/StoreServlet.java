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

public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		if(Objects.nonNull(user)) {
			request.setAttribute("color_agent", user.getCouleur_agent());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Store.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreForm storeForm = new StoreForm();
		User user = storeForm.UpdateColorAgent(request);
		if(Objects.nonNull(user)) {
			request.setAttribute("color_agent", user.getCouleur_agent());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Store.jsp").forward(request, response);
	}

}
