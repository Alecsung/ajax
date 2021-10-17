<%@ page language="java" contentType="text/html;charset=UTF-8"
	import="java.sql.*" %>
<%
	String name = request.getParameter("ename");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
	Connection conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
	
	String qryStmt = "SELECT ename FROM employee WHERE ename = ?";
	PreparedStatement stmt = conn.prepareStatement(qryStmt);
	stmt.setString(1, name);
	ResultSet rs = stmt.executeQuery();
	
	boolean isAccOk = false;
	if (rs.next())
		isAccOk = true;
	out.print(isAccOk);
	conn.close();
%>
