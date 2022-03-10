package com.bomberman.services;

import java.sql.Timestamp;
import com.bomberman.beans.Game;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.GameDao;

public class GameService {
	
	public GameService() {
		
	}
	
    public Game createGame() {   	
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        GameDao gameDao = daoFactory.getGameDao();
        
        Game game = new Game();
        
        game.setDate(new Timestamp(System.currentTimeMillis()));
        
		try {
			gameDao.create(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
        return game;
    }

}
