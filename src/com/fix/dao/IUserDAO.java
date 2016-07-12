package com.fix.dao;

import com.fix.model.User;
import com.fix.model.UserInfo;

public interface IUserDAO {
	public boolean addorupdateUser(User user,UserInfo userInfo);
	public User checkUser(User user);
	public User checkUserByToken(User user);
	public boolean addToken(User user);
}
