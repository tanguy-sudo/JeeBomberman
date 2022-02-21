package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	        
	        preparedStatement = connexion.prepareStatement("SELECT id, username, password FROM user WHERE username = ? AND password = ? ");
	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);
	        
	        resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	        	user = new User();
	        	user.setId(resultSet.getInt("id"));
	        	user.setUsername(resultSet.getString("username"));
	        	user.setPassword(resultSet.getString("password"));
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
	        preparedStatement.setString(2, password);
	        
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

}
