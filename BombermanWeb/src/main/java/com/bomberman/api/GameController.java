package com.bomberman.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import com.bomberman.services.GameService;
import com.bomberman.beans.Game;

/**
 * API qui gère les requêtes "/game/ que ce soit POST ou GET  
 * @author tanguy
 *
 */
public class GameController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GameController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Gestion de la requête POST sur "/game
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        GameService gameService = new GameService();	
        // Créer une game
		Game game = gameService.createGame();
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        // Si la game est créée, on envoie au client un succès avec l'id de la game
        if(Objects.nonNull(game)) { 
        	System.out.println("success, game added");	
            output.println("{ status : 201, id_game : " + game.getId() + " }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
