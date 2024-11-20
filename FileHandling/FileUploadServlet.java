package com.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet(description = "This is File Upload Servlet", urlPatterns = { "/FileUploadServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, //10 MB
				 maxFileSize = 1024 * 1024 * 30, // 30 MB
				 maxRequestSize = 1024 * 1024 * 50)//50 MB
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String UPLOAD_DIR = "uploadedFiles";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get absolute path of web application
		String applicationPath = getServletContext().getRealPath("");
		System.out.println("separator:"+File.separator);
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;

		File fileUploadDirectory = new File(uploadPath);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		System.out.println("upload directory path:"+ fileUploadDirectory.getAbsolutePath());
		List<UploadDetail> uploadDetails = new ArrayList<UploadDetail>();
		String fileName = "";
		UploadDetail uploadDetail = null;
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			uploadDetail = new UploadDetail();
			uploadDetail.setFileName(fileName);
			uploadDetail.setFileSize(part.getSize() / 1024);
			try {
				part.write(uploadPath + File.separator + fileName);
				uploadDetail.setUploadStatus("Success");
			} catch (Exception e) {
				uploadDetail.setUploadStatus("Failure:"+e.getLocalizedMessage());
			}
			uploadDetails.add(uploadDetail);
		}
		request.setAttribute("uploadDetails", uploadDetails);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/fileuploadResponse.jsp");
		dispatcher.forward(request, response);
	}

	private String extractFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2,item.length() - 1);
			}
		}
		return fileName;
	}

}
