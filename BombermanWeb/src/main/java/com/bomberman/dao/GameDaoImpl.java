package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.bomberman.beans.Game;
/**
 * Gestion des requêtes sur la table GAME en base de données
 * @author tanguy guillaume
 *
 */
public class GameDaoImpl implements GameDao{
	
	private DAOFactory daoFactory;	

	public GameDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * Crée une GAME en base de données
	 */
	@Override
	public void create(Game game) throws Exception {
		Connection connexion = null;
		PreparedStatement  preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		
		Timestamp date = game.getDate();
			
		try 
		{		        
			connexion = daoFactory.getConnection();
			
	        preparedStatement = connexion.prepareStatement("INSERT INTO game(date) VALUE(?)",  Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setTimestamp(1, date);
	        
			int statut = preparedStatement.executeUpdate();
			
			if(statut == 0)
			{
				throw new Exception();
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if(valeursAutoGenerees.next())
			{
				// Mets à jour id de la game
				game.setId(valeursAutoGenerees.getInt(1));
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
