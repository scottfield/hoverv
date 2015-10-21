package com.globalroam.iaas.hoverv.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;

public class MyHiddenHttpMethodFilter extends HiddenHttpMethodFilter {

	private String methodParam = DEFAULT_METHOD_PARAM;

	public void setMethodParam(String methodParam) {
		Assert.hasText(methodParam, "'methodParam' must not be empty");
		this.methodParam = methodParam;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String paramValue = request.getParameter(methodParam);
		String method = request.getMethod();
		if (StringUtils.hasLength(paramValue)) {
			String _method = paramValue.toUpperCase(Locale.ENGLISH);
			boolean b = ("POST".equals(method) && "PUT"
					.equalsIgnoreCase(_method))
					|| ("GET".equals(method) && "DELETE"
							.equalsIgnoreCase(_method));
//			System.out.println(paramValue);
//			System.out.println(b);
			if (b) {
				HttpServletRequest wrapper = new HttpMethodRequestWrapper(
						request, _method);
				filterChain.doFilter(wrapper, response);
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	private static class HttpMethodRequestWrapper extends
			HttpServletRequestWrapper {

		private final String method;

		public HttpMethodRequestWrapper(HttpServletRequest request,
				String method) {
			super(request);
			this.method = method;
		}

		@Override
		public String getMethod() {
			return this.method;
		}
	}

}
