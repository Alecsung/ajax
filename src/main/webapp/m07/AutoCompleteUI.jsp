<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
	String[] names = {"Anna","Brittany","Cinderella","Diana","Eva","Fiona",
		"Gunda","Hege","Inga","Johanna","Kitty","Linda","Nina","Ophelia",
		"Petunia","Amanda","Raquel","Cindy","Doris","Eve","Evita","Sunniva",
		"Tove","Unni","Violet","Liza","Elizabeth","Ellen","Wenche","Vicky"};

	String hint = "";
	for (String name : names)
		hint += (hint.equals("")) ? name : ", " + name;
	out.print(hint);
%>
