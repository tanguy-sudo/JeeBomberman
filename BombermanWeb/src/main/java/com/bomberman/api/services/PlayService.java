package com.bomberman.api.services;

import org.json.JSONObject;
import com.bomberman.beans.Play;
import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.PlayDao;

public class PlayService {
	
	public PlayService() {
		
	}
	
    public Play createPlay(JSONObject json) {   	
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        PlayDao playDao = daoFactory.getPlayDao();
        
        UserService userService = new UserService();		
		User user = userService.connectUser(json);
		
		if(user == null) {
			return null;
		} else {
	        Play play = new Play();
	        
	        play.setResults(json.getString("results"));
	        play.setId_game(json.getInt("id_game"));   
	        play.setId_user(user.getId());
	        
			try {
				playDao.create(play);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	        return play;
		}
    }

}
