package com.bomberman.forms;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;

public final class SignInForm {
	
    public User connectUser( HttpServletRequest request ) {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || password == null) {
        	return null;
        }
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        
        User user = null;
		try {
			user = userDao.find(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if(user == null)
        	return null;
        else 
        	return user;
    }

}
