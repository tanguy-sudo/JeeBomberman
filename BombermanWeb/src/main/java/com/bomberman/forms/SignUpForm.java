package com.bomberman.forms;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;

public final class SignUpForm {
	
    public User createUser(HttpServletRequest request) {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifpassword = request.getParameter("verifpassword");
        
        if(username == null || password == null || (username != verifpassword)) {
        	return null;
        }
        
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        
        DAOFactory daoFactory = DAOFactory.getInstance();
    	UserDao userDao = daoFactory.getUserDao();
    	
    	try {
			userDao.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return user;
    }

}
