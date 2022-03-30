package com.bomberman.beans;

import java.sql.Timestamp;
/**
 * Réprésentation de objet GAME
 * @author tanguy guillaume
 *
 */
public class Game {
	
	private int id;
	private Timestamp date;
	
	public Game() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}
