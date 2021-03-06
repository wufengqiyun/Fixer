package com.fix.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fix.dao.IOrderDAO;
import com.fix.model.Order;

public class OrderDAO implements IOrderDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean addorupdateOrder(Order order) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(order);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public List<Order> getallOrder() {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Order");
		List<Order> orders=query.list();
		ts.commit();
		session.close();
		return orders;
	}

	@Override
	public Order editOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delOrderById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getOrderByownerId(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Order where faultownerid='"+id+"'");
		List<Order> orders=query.list();
		ts.commit();
		session.close();
		return orders;
	}

	@Override
	public List<Order> getOrderByrepairerId(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Order where orderrepairid='"+id+"'");
		List<Order> orders=query.list();
		ts.commit();
		session.close();
		return orders;
	}

	@Override
	public Order getOrderByfaultId(String id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Order where faultid='"+id+"'");
		List<Order> orders=query.list();
		ts.commit();
		session.close();
		return orders.get(0);
	}

	@Override
	public List<Order> getOrderBystate(String state) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Order where orderstate='"+state+"'");
		List<Order> orders=query.list();
		ts.commit();
		session.close();
		return orders;
	}

}
