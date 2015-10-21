package com.globalroam.iaas.hoverv.exception;


import com.globalroam.iaas.hoverv.utility.JsonResponse;

/**
 * ECCUSTOM 自定义异常
 * 
 * @author Administrator
 *
 */
public class HVCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6868026989382209786L;
	private JsonResponse jsonResponse = null;
	
	public JsonResponse getJsonResponse() {
		if(jsonResponse == null) {
			jsonResponse = new JsonResponse();
			jsonResponse.setCode("-1000");
			jsonResponse.setMessage("error");
		}
		return jsonResponse;
	}
	
	public HVCustomException() {
	}

	public HVCustomException(String message) {
		super(message);
	}
}
