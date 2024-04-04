package com.digitalgoldwallet.controller.successresponse;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SuccessResponse {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime timestamp;
	private String message;
	
	public SuccessResponse(String message, LocalDateTime time) {
		this.message = message;
		this.timestamp = time;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
