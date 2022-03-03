package com.bomberman.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import com.bomberman.beans.User;
import com.bomberman.api.forms.SignInApiForm;

/**
 * Servlet implementation class SignInApi
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("mqsregfhuiesrhiukdhiroufgehirofhedi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        JSONObject json = new JSONObject(reader.readLine());
        
        String username = json.getString("username");
        String password = json.getString("password");
        
        SignInApiForm form = new SignInApiForm(username, password);		
		User user = form.connectUser(request);
        
        PrintWriter output = new PrintWriter(response.getOutputStream(), true);
        if(user != null) { 
        	System.out.println("success");	
            output.println("{ status : 201 }");	
        } else {
         	System.out.println("error");	
            output.println("{ status : 404 }");	
        }
	}

}
