package com.bomberman.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import org.json.JSONObject;
import com.bomberman.services.PlayService;
import com.bomberman.beans.Play;

/**
 * API qui gère les requêtes "/play/ que ce soit POST ou GET 
 * @author tanguy
 *
 */
public class PlayController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public PlayController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Gestion de la requête POST sur "/play
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        BufferedReader reader = request.getReader();
        // Récupération des informations que le client envoie
        JSONObject json = new JSONObject(reader.readLine());
        
        PlayService playService = new PlayService();	
        // Création d'une play(une play relie une game et un joueur)
		Play play = playService.createPlay(json);
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        // Si play est crée on envoie un succès
        if(Objects.nonNull(play)) { 
        	System.out.println("success, play added");	
            output.println("{ status : 201 }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
