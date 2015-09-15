package com.dzwz.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AllFilter implements Filter {
	
	private FilterConfig config;
	private String charset="utf-8";
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest  reuquest =(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		charset = config.getInitParameter("charset");
		if(charset!=null && !charset.equals("")){
			reuquest.setCharacterEncoding(charset);
			
		}
		arg2.doFilter(req, res);

		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
			this.config =config;
	}

}
