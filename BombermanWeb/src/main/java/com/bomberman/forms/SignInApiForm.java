package com.bomberman.forms;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;

public class SignInApiForm {
    private String username;
    private String password;
	
	public SignInApiForm(String u, String p) {
		this.username = u;
		this.password = p;
	}
	
    public User connectUser( HttpServletRequest request ) {   	
        
        if(this.username == null || this.password == null) {
        	return null;
        }
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDao userDao = daoFactory.getUserDao();
        
        User user = null;
		try {
			user = userDao.find(this.username, this.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if(user == null)
        	return null;
        else 
        	return user;
    }
}
