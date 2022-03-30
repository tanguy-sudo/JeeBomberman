package com.bomberman.forms;

import java.util.Objects;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
/**
 * Gestion des formulaires de la page Store
 * @author tanguy guillaume
 *
 */
public class StoreForm {
	
	/**
	 * Mets à jour la couleur de l'agent de l'utilisateur
	 * @param request
	 * @return user
	 */
    public User UpdateColorAgent(HttpServletRequest request) {
    	
        String color = request.getParameter("flexRadioDefault");
        
		HttpSession session = request.getSession();
		// Récupération de l'utilisateur connecté
		User user = (User) session.getAttribute("userSession");
		
		if(Objects.nonNull(user)) {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        UserDao userDao = daoFactory.getUserDao();
	        
	        try {
	        	// Mise à jour
				userDao.updateColorAgent(user, color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return user;
    }
}
