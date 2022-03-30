package com.bomberman.forms;

import java.util.Objects;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;
/**
 * Gestion des formulaires de la page SignIn
 * @author tanguy guillaume
 *
 */
public final class SignInForm {
	
	/**
	 * Test si l'utilisateur saisi existe en base de données
	 * @param request
	 * @return user
	 */
    public User connectUser( HttpServletRequest request ) {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(Objects.isNull(username) || Objects.isNull(password)) {
        	return null;
        }
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        
        User user = null;
		try {
			// Regarde si la combinaison de username et password existe
			user = userDao.find(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if(Objects.isNull(user))
        	return null;
        else 
        	return user;
    }

}
