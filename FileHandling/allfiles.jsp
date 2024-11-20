<%@page import="com.files.UploadDetail"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="main.css" />
<title>All uploaded files</title>
</head>
<body>
	<div class="panel">
		<h1>All uploaded files</h1>
		<table class="bordered_table">
			<thead>
				<tr>
					<th>FileName</th>
					<th>FileSize</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<UploadDetail> uploadDetails = (List<UploadDetail>) request.getAttribute("uploadDetails");
					if (uploadDetails.size() > 0) {
						for (int i = 0; i < uploadDetails.size(); i++) {
				%>
				<tr>
					<td><%=uploadDetails.get(i).getFileName()%></td>
					<td><%=uploadDetails.get(i).getFileSize()%></td>
					<td><a
						href="<%=request.getContextPath()%>/DownloadServlet?fileName=<%=uploadDetails.get(i).getFileName()%>">Download</a></td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td colspan="3">No Files uploaded.....</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<div class="margin_top_15px">
			<a href="<%=request.getContextPath()%>/fileupload.jsp">Back</a>
		</div>
	</div>
</body>
</html>