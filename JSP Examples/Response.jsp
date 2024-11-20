<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Action Response</title>
</head>
<body>
	<center>
		<h2>JSP Response</h2>
		<%
			Locale lcl = response.getLocale();
			out.println("Locale is : " + lcl + "\n");
			response.flushBuffer();
			PrintWriter output = response.getWriter();
			output.println("This is from writer object");
			String type = response.getContentType();
			out.println("The content type : " + type + "\n");
			// Set refresh,autoload time as 5 seconds
			response.setIntHeader("Refresh", 5);
			//Get current time
			Date dt = new Date();
			out.println("Today's date is : " + dt.toString() + "\n");
		%>
	</center>
</body>
</html>