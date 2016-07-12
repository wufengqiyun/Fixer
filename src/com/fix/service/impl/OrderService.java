package com.fix.service.impl;

import java.util.List;

import com.fix.dao.IOrderDAO;
import com.fix.model.Order;
import com.fix.service.IOrderService;

public class OrderService implements IOrderService {
	private IOrderDAO orderDAO;
	
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public boolean addorupdateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDAO.addorupdateOrder(order);
	}

	@Override
	public List<Order> getallOrder() {
		// TODO Auto-generated method stub
		return orderDAO.getallOrder();
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

}
