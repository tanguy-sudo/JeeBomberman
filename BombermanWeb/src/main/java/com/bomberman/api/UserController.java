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
import com.bomberman.beans.User;
import com.bomberman.services.UserService;

/**
 * API qui gère les requêtes "/user/ que ce soit POST ou GET 
 * @author tanguy
 *
 */
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Gestion de la requête POST sur "/user
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        // Récupération des informations que le client envoie(login, password)
        JSONObject json = new JSONObject(reader.readLine());
        
        UserService userService = new UserService();	
        // On teste la connexion d'un utilisateur et le retourne
		User user = userService.connectUser(json);
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        // Envoie un succès si l'utilisateur existe
        if(Objects.nonNull(user)) { 
        	System.out.println("success, user connected");	
            output.println("{ status : 201, couleur_agent : " + user.getCouleur_agent() + " }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
