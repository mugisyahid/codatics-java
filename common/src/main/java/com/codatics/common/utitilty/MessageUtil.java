
package com.codatics.common.utitilty;

public class MessageUtil {

	private String message;

	// prints the message
	public String printMessage() {
		System.out.println(message);
		return message;
	}

	public MessageUtil(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
