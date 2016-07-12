package com.fix.dao;

import java.util.List;

import com.fix.model.Order;

public interface IOrderDAO {
	//CRUD
		public boolean addorupdateOrder(Order order);
		public List<Order> getallOrder();
		public Order editOrderById(int id);
		public boolean delOrderById(int id);
	}
