<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
pageContext.setAttribute("student","ProductBatchStudent",pageContext.PAGE_SCOPE);
String name = (String)pageContext.getAttribute("student");
out.println("student name is " +name);
String pageName = page.toString();
out.println("Page Name is " +pageName);
out.print("Exception");
%>
<%= exception %>
</body>
</html>