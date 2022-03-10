package com.bomberman.services;

import org.json.JSONObject;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

public class UserService {
	
	public UserService() {
		
	}
	
    public User connectUser(JSONObject json) {  
    	
        String username = json.getString("username");
        String password = json.getString("password");
        
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
