package com.bomberman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
/**
 * Gestion de la connexion à la base de données
 * @author tanguy
 *
 */
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
    /**
     * Permet de créer une unique instance
     * @return DAOFactory
     */
    public static DAOFactory getInstance() {
    	if(Objects.isNull(instance)) {
	
	        try {
	        	 Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        instance = new DAOFactory("jdbc:mysql://localhost:3306/bombermanbdd", "tanguy", "tanguy");
    	}

        return instance;
    }
    

    /**
     * Retourne une connexion sur la base de données
     * @return Connection
     * @throws SQLException
     */
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
    
    public GameDao getGameDao()
    {
    	return new GameDaoImpl(this);
    }
    
    public PlayDao getPlayDao()
    {
    	return new PlayDaoImpl(this);
    }

}
