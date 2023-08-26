package com.velocity.exception;

public enum ErrorCodes {

	DATA_NOT_FOUND("001", "Data is not available on database"), INVALID_ID("002", "Requested id does not exist");

	private final String code;
	private final String message;

	ErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
