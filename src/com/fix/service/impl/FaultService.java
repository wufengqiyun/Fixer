package com.fix.service.impl;

import java.util.List;

import com.fix.dao.IFaultDAO;
import com.fix.model.Fault;
import com.fix.service.IFaultService;

public class FaultService implements IFaultService {
	private IFaultDAO faultDAO;
	public IFaultDAO getFaultDAO() {
		return faultDAO;
	}

	public void setFaultDAO(IFaultDAO faultDAO) {
		this.faultDAO = faultDAO;
	}

	@Override
	public boolean addorupdateFault(Fault fault) {
		// TODO Auto-generated method stub
		return faultDAO.addorupdateFault(fault);
	}

	@Override
	public List getallFault() {
		// TODO Auto-generated method stub
		return faultDAO.getallFault();
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
