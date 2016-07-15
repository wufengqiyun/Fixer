package com.fix.dao;

import java.util.List;

import com.fix.model.Fault;

public interface IFaultDAO {
	//CRUD
	public boolean addorupdateFault(Fault fault);
	public List getallFault();
	public Fault editFaultById(int id);
	public boolean delFaultById(int id);
	
	public Fault getFaultByFaultId(String id);
}
