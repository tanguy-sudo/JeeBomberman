package com.bomberman.beans;

/**
 * Réprésentation d'un objet User
 * @author tanguy guillaume
 *
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private String couleur_agent;
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCouleur_agent() {
		return couleur_agent;
	}

	public void setCouleur_agent(String couleur_agent) {
		this.couleur_agent = couleur_agent;
	}

}
