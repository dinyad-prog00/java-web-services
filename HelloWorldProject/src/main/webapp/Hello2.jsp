<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="beanHello" scope="request" class="fr.eilco.ejbmodel.HelloBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Bonjour Bonjour <jsp:getProperty name="beanHello" property="name"/>
</body>
</html>