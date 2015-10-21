package com.globalroam.iaas.hoverv.utility;

import java.util.Map;


public class JsonResponse {
	private String code;
	private String message;
	private Map<String,String> errors;
	private Object response;
	private String ACK;
	
	
	public String getACK() {
		return ACK;
	}

	public void setACK(String aCK) {
		ACK = aCK;
	}

	public JsonResponse(){
		this.code = "1000";
		this.message = "success";
	}
	
	public JsonResponse(String code,String message){
		this.code = code;
		this.message = message;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

//	public void putResponse(String key,T val) {
//		if(response == null) {
//			response = new HashMap<String, T>();
//		}
//		
//		response.put(key, val);
//	}
}
