package com.fix.service;

import java.util.List;

import com.fix.model.Fault;

public interface IFaultService {
	//CRUDId
	public boolean addorupdateFault(Fault fault);
	public List getallFault();
	public Fault editFaultById(int id);
	public boolean delFaultById(int id);
	
	public Fault getFaultByFaultId(String id);
}
