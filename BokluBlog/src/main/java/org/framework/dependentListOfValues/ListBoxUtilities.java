package org.framework.dependentListOfValues;

import java.util.Map;

public class ListBoxUtilities {
	
	private static ThreadLocal<AjaxResponse> errorResponse = new ThreadLocal<AjaxResponse>();
	private static ThreadLocal<Map<String,Object>> ajaxResponse = new ThreadLocal<Map<String,Object>>();
	
	public static void setError(AjaxResponse error) {
		errorResponse.set(error);
	}
	
	public static void clearError() {
		errorResponse.remove();
	}
	
	public static AjaxResponse getError() {
		return errorResponse.get();
	}
	
	public static void setResponse(Map<String,Object> response) {
		ajaxResponse.set(response);
	}
	
	public static void clearResponse() {
		ajaxResponse.remove();
	}
	
	public static Map<String,Object> getResponse(){
		return ajaxResponse.get();
	}

}
