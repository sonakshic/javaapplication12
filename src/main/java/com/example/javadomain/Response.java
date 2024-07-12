package com.example.javadomain;

import com.example.javaresposity.IResponse;

public class Response implements IResponse {

	public Response(int zStatus, String zMessage, Object zDetails) {
		status = zStatus;
		message = zMessage;
		details = zDetails;
	}

	public static final int SUCCESS_RESP = 0;
	public static final String SUCCESS_MESSAGE = "Success";
	public static final int VALIDATION_ERROR = 100;
	public static final String VALIDATION_ERROR_MESSAGE = "Validation error";

	private int status = 0;

	private String message = "Success";

	private Object details;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
