package com.fix.dao.impl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fix.dao.IUserDAO;
import com.fix.model.Order;
import com.fix.model.User;
import com.fix.model.UserInfo;

public class UserDAO implements IUserDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addorupdateUser(User user,UserInfo userInfo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();		
		session.saveOrUpdate(user);
//		userInfo.setUserid("123");
//		session.saveOrUpdate(userInfo);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from User where userpassword='"+user.getUserpassword()+"' and phonenumber='"+user.getPhonenumber()+"' ");
		List userList=query.list();
		ts.commit();
		session.close();
		if (userList.size()!=0) {
			User user1=new User();
			user1=(User) userList.get(0);
			return user1;
		}
		return null;
	}

	@Override
	public User checkUserByToken(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from User where token='"+user.getToken()+"'  ");
		List userList=query.list();
		User user1=new User();
		ts.commit();
		session.close();
		if (userList.size()!=0) {
			user1=(User) userList.get(0);
			return user1;
		}
		return null;
	}
	
	public boolean addToken(User user){
		// TODO Auto-generated method stub;
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		
		session.saveOrUpdate(user);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public List getallRepairer() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from User where role='"+2+"' ");
	//	List repairers=query.list();
		ts.commit();
		List repairers=query.list();
		session.close();
		return repairers;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from User where userid='"+id+"'");
		List<User> users=query.list();
		ts.commit();
		session.close();
		return users.get(0);
	}
}
