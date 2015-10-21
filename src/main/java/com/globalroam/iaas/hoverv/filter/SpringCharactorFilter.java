package com.globalroam.iaas.hoverv.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Servlet Filter implementation class CharactorFilter
 */
public class SpringCharactorFilter extends CharacterEncodingFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		super.doFilterInternal(new MyHttpServletRequest(request), response, filterChain);
	}
	

	private static class MyHttpServletRequest extends HttpServletRequestWrapper {
		private HttpServletRequest request;
		private String encode = "utf-8";
		
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
//			this.encode = request.getCharacterEncoding();
		}

		@Override
		public String getParameter(String name) {
			// 对GET请求参数重新编码
			 String value = request.getParameter(name);
//			 System.out.println("SpringCharactorFilter before value:" + value);
//			 System.out.println("SpringCharactorFilter encoding:" + request.getCharacterEncoding());
//			 System.out.println("SpringCharactorFilter method:" + request.getMethod());
//			 System.out.println(encode);
			try {
				if (value != null && "GET".equals(request.getMethod())) {
					value = new String(value.getBytes("iso-8859-1"),
							encode);
//					System.out.println("SpringCharactorFilter after value:" + value);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}

		@Override
		public String[] getParameterValues(String name) {
			String[] values = request.getParameterValues(name);
			List<String> list = new ArrayList<String>();
//			System.out.println(encode);
			try {
//				 System.out.println(values.length);
//				 System.out.println("getParameterValues ==>" + request.getMethod());
				if (values != null && values.length > 0 && "GET".equals(request.getMethod())) {
					for (String value : values) {
//						 System.out.println("before value:" + value);
						value = new String(value.getBytes("iso-8859-1"),
								encode);
//						 System.out.println("after value:" + value);
						list.add(value);
					}
					values = list.toArray(new String[values.length]);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return values;
		}

	}
}
