package com.bomberman.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import com.bomberman.api.services.PlayService;
import com.bomberman.beans.Play;


public class PlayController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public PlayController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        BufferedReader reader = request.getReader();
        JSONObject json = new JSONObject(reader.readLine());
        
        PlayService playService = new PlayService();		
		Play play = playService.createPlay(json);
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        if(play != null) { 
        	System.out.println("success, play added");	
            output.println("{ status : 201 }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
