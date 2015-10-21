package com.globalroam.iaas.hoverv.utility;


/**
 * @author dengjiepeng:
 * @areate Date:2012-3-13
 * 
 */
public class ForwardUtility {


	public static String FORWARD_BASE_PATH = "forward:";
	public static String REDIRECT_BASE_PATH = "redirect:";


	public static String forwardAdminView(String path){
		return "/WEB-INF/view/" + processSlash(path);
	}

	public static String redirectWithSpringMVC(String path) {
		return REDIRECT_BASE_PATH + processSlash(path);
	}
	
	public static String processSlash(String str) {
		String result = "";
		if(str!=null&&!"".equals(str)&&str.length()!=0) {
			if(str.startsWith("/")) {
				result = str;
			}else{
				result = "/" + str;
			}
		}
		return result;
	}
	
}
