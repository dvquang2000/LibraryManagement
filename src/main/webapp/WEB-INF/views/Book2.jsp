<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<c:forEach items = "${book}" var ="i">
	 id: ${i.id}
	 title: ${i.title}
	<br>
	</c:forEach>
</body>
</html>