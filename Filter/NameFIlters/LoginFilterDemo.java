package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilterDemo extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("Text/Html");
		String userId = request.getParameter("userId");
		String userPassWord = request.getParameter("userPassWord");
		out.println("<html>");
		out.println("<body bgcolor=silver>");
		out.println("<h2> Getting Parameter from User Example</h2>");
		out.println("<b><Font color=blue >");
		out.println("User Id is -" + userId);
		out.println("<br>");
		out.println("User PassWord is -" + userPassWord);
		out.println("</b></font>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}