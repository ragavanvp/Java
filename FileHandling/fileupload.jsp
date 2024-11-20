<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="main.css" />
<title>Servlet3 File Uploading</title>
</head>
<body>
	<div class="panel">
		<a href="<%=request.getContextPath()%>/UploadedFilesServlet">All
			Uploaded Files</a>
	</div>
	<div class="margin_top_15px">&nbsp;</div>
	<div class="panel">
		<h1>Single File Upload</h1>
		<form method="post" action="FileUploadServlet"
			enctype="multipart/form-data">
			<div class="form_group">
				<label>Upload file</label> <input type="file" name="fileUpload" />
			</div>
			<button type="submit" class="btn btn_primary"> Upload</button>
		</form>
	</div>
	<div class="margin_top_15px">&nbsp;</div>
	<div class="panel">
		<h1>Multiple Files Upload(Not support for IE&lt;10)</h1>
		<h3>Press CTRL key+click on file to select multiple file in Open
			dialog</h3>
		<form method="post" action="FileUploadServlet"
			enctype="multipart/form-data">
			<div class="form_group">
				<label>Upload file</label> <input type="file" name="fileUpload"
					multiple="multiple" />
			</div>
			<button type="submit" class="btn btn_primary"> Upload</button>
		</form>
	</div>
</body>
</html>