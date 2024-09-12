<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Bonjour <%= request.getParameter("name") %>
Bonjour <%= request.getAttribute("name") %>

Cool
<br/>
<%
String name = (String)request.getAttribute("name");
name = "M. " + name;
%>
Hello <%= name %>
</body>
</html>