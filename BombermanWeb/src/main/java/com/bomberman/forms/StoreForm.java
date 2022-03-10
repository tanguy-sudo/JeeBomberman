package com.bomberman.forms;

import java.util.Objects;

import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.UserDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class StoreForm {
	
    public User UpdateColorAgent(HttpServletRequest request ) {
    	
        String color = request.getParameter("flexRadioDefault");
        
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		
		if(Objects.nonNull(user)) {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        UserDao userDao = daoFactory.getUserDao();
	        
	        try {
				userDao.updateColorAgent(user, color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return user;
    }
}
