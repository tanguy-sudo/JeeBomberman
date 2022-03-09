package com.bomberman.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.bomberman.api.services.GameService;
import com.bomberman.beans.Game;

public class GameController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GameController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        GameService gameService = new GameService();		
		Game game = gameService.createGame();
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        if(game != null) { 
        	System.out.println("success, game added");	
            output.println("{ status : 201, id_game : " + game.getId() + " }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
