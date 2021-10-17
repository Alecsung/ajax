package com.lcpan.m07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetRSS")
public class GetRSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String RSS_URL =
			"http://rss.cnn.com/rss/edition_world.rss";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		URL url = new URL(RSS_URL);			
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()));
		StringBuilder sb = new StringBuilder(1024);
		String str;
		while ((str = in.readLine()) != null)
			sb.append(str);
		in.close();
		response.getWriter().print(sb.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
