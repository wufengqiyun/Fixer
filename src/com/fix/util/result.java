package com.fix.util;

public class result {
	private String flag;
	private String error;
	private String msg;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public result(String flag, String error, String msg) {
		super();
		this.flag = flag;
		this.error = error;
		this.msg = msg;
	}
	
}
