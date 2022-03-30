package com.bomberman.forms;

import java.util.Objects;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;
/**
 * Gestion des formulaires de la page SignUp
 * @author tanguy guillaume
 *
 */
public final class SignUpForm {
	/**
	 * Essaye de créer un utilisateur en base de données
	 * @param request
	 * @return user
	 */
    public User createUser(HttpServletRequest request) {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifpassword = request.getParameter("verifpassword");
        
        if(Objects.isNull(username) || Objects.isNull(password)) {
        	return null;
        }
        
        // Vérifie que password et verifpassword sont égaux
        if(!password.equals(verifpassword)) {
        	return null;
        }
        
        
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setCouleur_agent("DEFAULT");
        
        DAOFactory daoFactory = DAOFactory.getInstance();
    	UserDao userDao = daoFactory.getUserDao();
    	
    	try {
    		// Création d'un utilisateur
			userDao.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        return user;
    }

}
