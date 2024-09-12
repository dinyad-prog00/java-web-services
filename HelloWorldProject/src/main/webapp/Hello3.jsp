<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.Collection, java.util.Iterator,fr.eilco.ejbmodel.HelloBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Collection<HelloBean> beanHello = (Collection<HelloBean>)
	session.getAttribute("beanHello");
	if (beanHello != null){
	Iterator<HelloBean> it = beanHello.iterator();
	while(it.hasNext()){
	HelloBean aBean = it.next();
	%>
	Bonjour <%= aBean.getName() %> <br/>
	<%
	}
}
%>
</body>
</html>