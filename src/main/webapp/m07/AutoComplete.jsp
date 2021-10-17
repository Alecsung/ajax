<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
	String[] names = {"Anna","Brittany","Cinderella","Diana","Eva","Fiona",
		"Gunda","Hege","Inga","Johanna","Kitty","Linda","Nina","Ophelia",
		"Petunia","Amanda","Raquel","Cindy","Doris","Eve","Evita","Sunniva",
		"Tove","Unni","Violet","Liza","Elizabeth","Ellen","Wenche","Vicky"};

	String pname = request.getParameter("q");
	String hint = "";
	if (!pname.equals("") && pname != null) {
		pname = pname.toLowerCase();
		int len = pname.length();
		for (String name : names) {
			if (pname.equals(name.toLowerCase().substring(0, len))) {
				hint += (hint.equals("")) ? name : ", " + name;
			}
		}
	}
	out.print(hint.equals("") ? "no suggestion" : hint);
%>
