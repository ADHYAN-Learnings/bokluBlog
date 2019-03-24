package org.framework.dependentListOfValues;

public class AjaxResponse {
	
	private String responseType = "";
	private String responseMessage = "";
	private String errorCode = "";
	
	public AjaxResponse(String responseType, String responseMessage, String errorCode) {
		super();
		this.responseType = responseType;
		this.responseMessage = responseMessage;
		this.errorCode = errorCode;
	}

	public AjaxResponse() {
		super();
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
