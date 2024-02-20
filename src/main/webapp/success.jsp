<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.UserData.*"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged in</title>
</head>
<body>
	<%
	user ur = (user) session.getAttribute("user");
	if (ur == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>You are successfully logged in</h1>

	<h2>
		Hi
		<%=ur.getFname()%></h2>
	<h2><%=ur.getLname()%></h2>

</body>
</html>