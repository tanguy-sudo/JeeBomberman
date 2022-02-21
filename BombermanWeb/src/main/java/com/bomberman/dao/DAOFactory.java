package com.bomberman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	
    private static DAOFactory instance = null;
	
    private String url;
    private String username;
    private String password;

    DAOFactory(String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public static DAOFactory getInstance() {
    	if(instance == null) {
	
	        try {
	        	 Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        instance = new DAOFactory("jdbc:mysql://localhost:3306/bombermanBdd", "root", "");
    	}

        return instance;
    }
    

	Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(url, username, password );
    }
	
    public UserDao getUserDao()
    {
    	return new UserDaoImpl(this);
    }

}
