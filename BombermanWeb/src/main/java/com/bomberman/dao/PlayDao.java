package com.bomberman.dao;

import java.util.List;

import com.bomberman.beans.Play;
import com.bomberman.beans.User;

public interface PlayDao {
	
	void create(Play play) throws Exception;
	
	List<Play> findAll(User user) throws Exception;
	
}
