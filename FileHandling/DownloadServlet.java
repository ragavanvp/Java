package com.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet(description = "Download file from server", urlPatterns = { "/DownloadServlet" })
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploadedFiles";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		String applicationPath = getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		String filePath = uploadPath + File.separator + fileName;
		File file = new File(filePath);
		FileInputStream inputStream = null;
		if (file.exists()) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment;filename="+fileName);
			try {
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[1024 * 100];
				while (inputStream.read(buffer) != -1) {
					response.getOutputStream().write(buffer);
					response.getOutputStream().flush();
				}
				response.getOutputStream().close();
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		}else{
			response.setContentType("text/html");
			response.getWriter().write("<h3>File "+fileName+" is not present</h3>");
		}

	}

}
