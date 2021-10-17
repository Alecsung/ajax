<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	out.print("<p>Dear " + name + ", </p>");
	out.print("<p>Hope you live well in " + city + ".</p>");
 %>
 