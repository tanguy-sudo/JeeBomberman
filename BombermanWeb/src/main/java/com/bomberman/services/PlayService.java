package com.bomberman.services;

import java.util.List;
import java.util.Objects;

import org.json.JSONObject;
import com.bomberman.beans.Play;
import com.bomberman.beans.User;
import com.bomberman.dao.DAOFactory;
import com.bomberman.dao.PlayDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class PlayService {
	
	public PlayService() {
		
	}
	
	/**
	 * Créer une play
	 * @param json
	 * @return PLay
	 */
    public Play createPlay(JSONObject json) {   	      
        DAOFactory daoFactory = DAOFactory.getInstance();
        PlayDao playDao = daoFactory.getPlayDao();
        
        UserService userService = new UserService();		
		User user = userService.connectUser(json);
		
		if(Objects.isNull(user)) {
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
    
   /**
    * Créer une liste de play du joueur
    * @param request
    * @return List<Play>
    */
   public List<Play> getPlay(HttpServletRequest request) {     
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		
        List<Play> plays = null;
		
		if(Objects.nonNull(user)) {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        PlayDao playDao = daoFactory.getPlayDao();
	        
	        try {
	        	plays = playDao.findAll(user);        	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return plays;
   }

}
