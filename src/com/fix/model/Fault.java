package com.fix.model;

/**
 * Fault entity. @author MyEclipse Persistence Tools
 */

public class Fault implements java.io.Serializable {

	// Fields

	private String faultid;
	private String faulttitle;
	private String faultcontent;
	private String faulttime;
	private String faultlocation;
	private String faultphone;
	private String faultdesc;
	private String faultowner;
	private String faultownerid;
	private String faultpictures;

	// Constructors

	/** default constructor */
	public Fault() {
	}

	/** full constructor */
	public Fault(String faulttitle, String faultcontent, String faulttime,
			String faultlocation, String faultphone, String faultdesc,
			String faultowner, String faultownerid, String faultpictures) {
		this.faulttitle = faulttitle;
		this.faultcontent = faultcontent;
		this.faulttime = faulttime;
		this.faultlocation = faultlocation;
		this.faultphone = faultphone;
		this.faultdesc = faultdesc;
		this.faultowner = faultowner;
		this.faultownerid = faultownerid;
		this.faultpictures = faultpictures;
	}

	// Property accessors

	public String getFaultid() {
		return this.faultid;
	}

	public void setFaultid(String faultid) {
		this.faultid = faultid;
	}

	public String getFaulttitle() {
		return this.faulttitle;
	}

	public void setFaulttitle(String faulttitle) {
		this.faulttitle = faulttitle;
	}

	public String getFaultcontent() {
		return this.faultcontent;
	}

	public void setFaultcontent(String faultcontent) {
		this.faultcontent = faultcontent;
	}

	public String getFaulttime() {
		return this.faulttime;
	}

	public void setFaulttime(String faulttime) {
		this.faulttime = faulttime;
	}

	public String getFaultlocation() {
		return this.faultlocation;
	}

	public void setFaultlocation(String faultlocation) {
		this.faultlocation = faultlocation;
	}

	public String getFaultphone() {
		return this.faultphone;
	}

	public void setFaultphone(String faultphone) {
		this.faultphone = faultphone;
	}

	public String getFaultdesc() {
		return this.faultdesc;
	}

	public void setFaultdesc(String faultdesc) {
		this.faultdesc = faultdesc;
	}

	public String getFaultowner() {
		return this.faultowner;
	}

	public void setFaultowner(String faultowner) {
		this.faultowner = faultowner;
	}

	public String getFaultownerid() {
		return this.faultownerid;
	}

	public void setFaultownerid(String faultownerid) {
		this.faultownerid = faultownerid;
	}

	public String getFaultpictures() {
		return this.faultpictures;
	}

	public void setFaultpictures(String faultpictures) {
		this.faultpictures = faultpictures;
	}

}