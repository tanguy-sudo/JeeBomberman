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
/**
 * Gestion des requêtes sur la table USER en base de données
 * @author tanguy
 *
 */
public class UserDaoImpl implements UserDao {
	
	private DAOFactory daoFactory;
	
	UserDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * Retourne un utilisateur stocké en base de données s'il existe
	 */
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
	        // Chiffre le mot de passe
	        preparedStatement.setString(2, encrypt(password));
	        
	        resultSet = preparedStatement.executeQuery();
	        
	        // Création d'un objet user
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

	/**
	 * Crée un utilisateur
	 */
	@Override
	public void create(User user) throws Exception {
		Connection connexion = null;
		PreparedStatement  preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		
		String username = user.getUsername();
		String password = user.getPassword();
		String color_agent = user.getCouleur_agent();
			
		try 
		{		        
			connexion = daoFactory.getConnection();
			
	        preparedStatement = connexion.prepareStatement("INSERT INTO user(username, password, couleur_agent) VALUE(?,?,?)", Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, username);
	        // Chiffre le mot de passe
	        preparedStatement.setString(2, encrypt(password));
	        preparedStatement.setString(3, color_agent);
	        
			int statut = preparedStatement.executeUpdate();
			
			if(statut == 0)
			{
				throw new Exception();
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if(valeursAutoGenerees.next() )
			{
				// Mets à jour l'id de l'utilisateur
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
    
	/**
	 * Chiffre le mot de passe
	 * @param data
	 * @return un mot de passe chiffré
	 * @throws Exception
	 */
    private String encrypt(String data) throws Exception{
    	  MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));	    
    	  return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Mets à jour la couleur de l'agent d'un utilisateur en base de données
     */
	@Override
	public void updateColorAgent(User user,  String color) throws Exception{
		Connection connexion = null;
		PreparedStatement  preparedStatement = null;
		
		int id = user.getId();
			
		try 
		{		        
			connexion = daoFactory.getConnection();
			
	        preparedStatement = connexion.prepareStatement("UPDATE user SET couleur_agent = ? where id = ?");
	        preparedStatement.setString(1, color);
	        preparedStatement.setInt(2, id);
	        
	        // Exécute la requête
			int statut = preparedStatement.executeUpdate();
			
			if(statut == 0)
			{
				throw new Exception();
			}		
			user.setCouleur_agent(color);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			  connexion.close();
		}	
	}
    
}
