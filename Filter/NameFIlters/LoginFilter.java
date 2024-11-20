package com;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	public LoginFilter() {
	}

	public final static String devil = "ALICE";
	private FilterConfig filterConfig;

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login Filter Example</title></head>");
		String username = request.getParameter("userId");
		HttpServletResponse httpResponse = null;
		if (response instanceof HttpServletResponse) {
			httpResponse = (HttpServletResponse) response;
		}
		BufferedReader input = new BufferedReader(new FileReader("D://Username.txt"));
		String line = "";
		while ((line = input.readLine()) != null) {
			if (line.equals(username)) {
				httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "You are not allowed to access the servlet!");
			}
		}
		filterchain.doFilter(request, response);
		out.println("<body><h3><font color='green'>Passed successfully from Login Filter<font></h3></body></html>");
	}

	public void destroy() {
	}
}