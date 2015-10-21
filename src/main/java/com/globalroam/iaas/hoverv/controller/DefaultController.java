package com.globalroam.iaas.hoverv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DefaultController {
	private static final Logger logger = Logger.getLogger(DefaultController.class);
	
	/**
	 * TEMPLATE FILE VIEW
	 * @param request
	 * @param response
	 * @return
	 * @throws ECAuthException
	 * @throws Exception
	 */
	public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "index";
	}
}
