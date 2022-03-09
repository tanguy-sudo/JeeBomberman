package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import com.bomberman.beans.User;

public class UserDaoImpl implements UserDao {
	
	private DAOFactory daoFactory;
	
	UserDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public User find(String username, String password) throws Exception {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		
	    try {
	        connexion = daoFactory.getConnection();
	        
	        preparedStatement = connexion.prepareStatement("SELECT id, username, password, couleur_agent FROM user WHERE username = ? AND password = ? ", Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, encrypt(password));
	        
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	        	user = new User();
	        	user.setId(resultSet.getInt("id"));
	        	user.setUsername(resultSet.getString("username"));
	        	user.setPassword(resultSet.getString("password"));
	        	user.setCouleur_agent(resultSet.getString("couleur_agent"));
	        }
	        
	    } catch (SQLException e) {
	        System.out.print(e.getMessage());
	    } finally {
	    	  connexion.close();
	    }		

		return user;
	}

	@Override
	public void create(User user) throws Exception {
		Connection connexion = null;
		PreparedStatement  preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		
		String username = user.getUsername();
		String password = user.getPassword();
			
		try 
		{		        
			connexion = daoFactory.getConnection();
			
	        preparedStatement = connexion.prepareStatement("INSERT INTO user(username, password) VALUE(?,?)");
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, encrypt(password));
	        
			int statut = preparedStatement.executeUpdate();
			
			if(statut == 0)
			{
				throw new Exception();
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if(valeursAutoGenerees.next() )
			{
				user.setId(valeursAutoGenerees.getInt(1));
			}
			else
			{
				throw new Exception();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			  connexion.close();
		}
	}
    
    private String encrypt(String data) throws Exception{
    	  MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));	    
    	  return Base64.getEncoder().encodeToString(hash);
    }
    
}
