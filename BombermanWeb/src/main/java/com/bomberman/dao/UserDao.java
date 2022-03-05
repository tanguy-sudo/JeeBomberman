package com.bomberman.dao;

import com.bomberman.beans.User;

public interface UserDao {
	
	User find (String username,String password) throws Exception;
	
	void create(User user) throws Exception;

}
