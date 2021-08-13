<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/Search">
         <table border="0">
            <tr>
               <td><input type="submit" value= "Search" /></td>
               <td><input type="text" name="string" value= "${user.password}" /> </td>
            </tr>
         </table>
      </form>
</body>
</html>