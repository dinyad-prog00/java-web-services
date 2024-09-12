<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery</title>
</head>
<body>
	<h1>Delivery</h1>
	<span>${delivery.deliveryId}</span>
	<span>${delivery.deliveryAddress}</span>
	<span>${delivery.deliveryDate}</span>
	<span>${delivery.recipientName}</span>
</body>
</html>