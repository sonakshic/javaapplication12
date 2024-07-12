package com.example.javadomain;

import java.io.Serializable;

import com.example.javaentity.Users;

public class LongResponse  {

	private String token;
	private String message;
	private Object obj;

//	public LongResponse(String token, String message, Object obj) {
//		super();
//		this.token = token;
//		this.message = message;
//
//		this.obj = obj;
//	}

	public LongResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
