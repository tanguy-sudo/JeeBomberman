package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bomberman.beans.Play;

public class PlayDaoImpl implements PlayDao{
	
	private DAOFactory daoFactory;	

	public PlayDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Play play) throws Exception {
		Connection connexion = null;
		PreparedStatement  preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		
		String results = play.getResults();
		int id_game = play.getId_game();
		int id_user = play.getId_user();
			
		try 
		{		        
			connexion = daoFactory.getConnection();
			
	        preparedStatement = connexion.prepareStatement("INSERT INTO play(results, id_game, id_user) VALUE(?,?,?)", Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, results);
	        preparedStatement.setInt(2, id_game);
	        preparedStatement.setInt(3, id_user);
	        
			int statut = preparedStatement.executeUpdate();
			
			if(statut == 0)
			{
				throw new Exception();
			}
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if(valeursAutoGenerees.next() )
			{
				play.setId(valeursAutoGenerees.getInt(1));
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
