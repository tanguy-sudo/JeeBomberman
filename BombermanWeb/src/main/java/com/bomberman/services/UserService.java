package com.bomberman.services;

import java.util.Objects;

import org.json.JSONObject;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

public class UserService {
	
	public UserService() {
		
	}
	
	/**
	 * Test si le login et le password correspondent à un utilisateur
	 * @param json
	 * @return User
	 */
    public User connectUser(JSONObject json) {  
    	
        String username = json.getString("username");
        String password = json.getString("password");
        
        if(Objects.isNull(username) || Objects.isNull(password)) {
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
		
        if(Objects.isNull(user))
        	return null;
        else 
        	return user;
    }
}
