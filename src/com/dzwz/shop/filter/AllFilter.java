package com.dzwz.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


public class AllFilter implements Filter {
	
	private FilterConfig config;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest  reuqest =(HttpServletRequest)req;
		String charset = config.getInitParameter("charset");
		if(charset!=null && !charset.equals("")){
			reuqest.setCharacterEncoding("utf-8");
		}
		arg2.doFilter(req, res);

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			this.config =arg0;
	}

}
