package com.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadedFilesServlet
 */
@WebServlet("/UploadedFilesServlet")
public class UploadedFilesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploadedFiles";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String applicationPath = getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		File fileUploadDirectory = new File(uploadPath);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		List<UploadDetail> uploadDetails = new ArrayList<UploadDetail>();
		File[] allFiles = fileUploadDirectory.listFiles();
		for (File file : allFiles) {
			UploadDetail uploadDetail = new UploadDetail();
			uploadDetail.setFileName(file.getName());
			uploadDetail.setFileSize(file.length() / 1024);
			uploadDetails.add(uploadDetail);
		}
		request.setAttribute("uploadDetails", uploadDetails);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/allfiles.jsp");
		dispatcher.forward(request, response);
	}

}
