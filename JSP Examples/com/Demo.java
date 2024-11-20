package com;

import java.io.Serializable;

public class Demo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String msg = "null";

	public String getMsg() 
	{
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
