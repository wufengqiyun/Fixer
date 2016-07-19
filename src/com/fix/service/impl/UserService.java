package com.fix.service.impl;

import java.util.List;

import com.fix.dao.IUserDAO;
import com.fix.model.User;
import com.fix.model.UserInfo;
import com.fix.service.IUserService;

public class UserService implements IUserService {
	private IUserDAO userDAO;
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(user);
	}

	@Override
	public boolean addorupdateUser(User user, UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userDAO.addorupdateUser(user, userInfo);
	}

	@Override
	public User checkUserByToken(User user) {
		// TODO Auto-generated method stub
		return userDAO.checkUserByToken(user);
	}

	@Override
	public boolean addToken(User user) {
		// TODO Auto-generated method stub
		return userDAO.addToken(user);
	}

	@Override
	public List getallRepairer() {
		// TODO Auto-generated method stub
		return userDAO.getallRepairer();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(id);
	}

}
