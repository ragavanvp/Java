<%@page import="com.files.UploadDetail"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="main.css" />
<title>File Upload Response</title>
</head>
<body>
	<div class="panel">
		<h1>File Upload Status:</h1>
		<table class="bordered_table">
			<thead>
				<tr>
					<th>FileName</th>
					<th>FileSize</th>
					<th>Upload Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<% List<UploadDetail> uploadDetails=(List<UploadDetail>)request.getAttribute("uploadDetails");
		    			for(int i=0;i<uploadDetails.size();i++){
		    	    %>
				<tr>
					<td><%=uploadDetails.get(i).getFileName() %></td>
					<td><%=uploadDetails.get(i).getFileSize() %>Kb</td>
					<td><%=uploadDetails.get(i).getUploadStatus() %></td>
					<td><a
						href="<%=request.getContextPath()%>/DownloadServlet?fileName=<%=uploadDetails.get(i).getFileName()%>">Download</a></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<div class="margin_top_15px">
			<a href="<%=request.getContextPath()%>/fileupload.jsp">Back</a>
		</div>
	</div>
</body>
</html>