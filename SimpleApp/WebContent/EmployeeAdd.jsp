<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="add">
		<h1>Add Employee</h1>
		<form action="EmployeeController" method="GET">
			<table>
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" name="ename"></td>
				</tr>
				<tr>
					<td>Employee Number:</td>
					<td><input type="text" name="enumber"></td>
				</tr>
				<tr>
					<td><input type="submit" name="addEmployee" value="Add"></td>

				</tr>
			</table>
		</form>
	</div>
	<form action="EmployeeController" method="POST">
		<input type="submit" name="showEmployee" value="Show"> &nbsp;
		&nbsp;<br>


	</form>
</body>
</html>