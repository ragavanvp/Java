package com.multipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "FileUpload", urlPatterns = { "/FileUpload" })
@MultipartConfig
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String uploadFolderName = "uploads";
	private static volatile String uploadFolder = null;

	public FileUpload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			processRequest(request, response);
		} catch (IOException e) {
			out.print("<br>ERROR! " + e.getMessage());
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		final Part filePart = request.getPart("file");
		final String fileName = getFileName(filePart);
		final String serverFilePath = getUploadFolder() + File.separator + fileName;
		long timeBefore = System.currentTimeMillis();
		String writeMethod = request.getParameter("writemethod");
		if (writeMethod.equals("partwrite")) {
			out.println("<br>Using Part.write method...");
			filePart.write(serverFilePath);
		} else {
			out.println("<br>Using Part.write method...");
			writeToFileUsingFileOutputStream(filePart.getInputStream(), serverFilePath);
		}
		long timeAfter = System.currentTimeMillis();
		out.println("<br>New file " + fileName + " created at " + serverFilePath);
		out.println("<br>Time elapsed= " + (timeAfter - timeBefore));
	}

	private String getUploadFolder() { // synchronization
		// not handled.
		if (uploadFolder == null) {
			String contextRealPath = getServletContext().getRealPath("/");
			uploadFolder = contextRealPath + File.separator + uploadFolderName;
			File dir = new File(uploadFolder);
			if (!dir.exists()) {
				boolean create = dir.mkdir();
				if (create) {
					System.out.println("Uploads directory created:" + uploadFolder);
				} else {
					throw new RuntimeException("Directory Cannot Be Created!");
				}
			}
		}
		return uploadFolder;
	}

	private void writeToFileUsingFileOutputStream(InputStream filecontent, String filePath) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(filePath));
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		String[] sections = partHeader.split(";");
		for (String content : sections) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}