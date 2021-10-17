package com.lcpan.m05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadOneFile")
@MultipartConfig
public class UploadOneFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("photo");
		String header = part.getHeader("Content-Disposition");
		// form-data; name="photo"; filename="pandas.jpg"
		// form-data; name="photo"; filename="D:\images\pandas.jpg"
		int slashIdx = header.lastIndexOf("\\");
		String filename;
		if (slashIdx != -1)
			filename = header.substring(slashIdx + 1, header.length()-1);			
		else {
			int idx = header.indexOf("filename");
			filename = header.substring(idx + 10, header.length()-1);			
		}
		
		InputStream in = part.getInputStream();
		OutputStream out = new FileOutputStream("C:/uploadFiles/" + filename);
		byte[] buf = new byte[1024];
		int length;
		while ((length = in.read(buf)) != -1)
			out.write(buf, 0, length);
		in.close();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
