package com.bomberman.beans;
/**
 * Réprésentaion d'un objet Play
 * @author tanguy guillaume
 *
 */
public class Play {
	
	private int id;
	private String results;
	private int id_game;
	private int id_user;
	
	public Play() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
}
