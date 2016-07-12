package com.fix.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fix.dao.IFaultDAO;
import com.fix.model.Fault;

public class FaultDAO implements IFaultDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addorupdateFault(Fault fault) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(fault);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public List getallFault() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Fault");
		List faults=query.list();
		ts.commit();
		session.close();
		return faults;
	}

	@Override
	public Fault editFaultById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delFaultById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
