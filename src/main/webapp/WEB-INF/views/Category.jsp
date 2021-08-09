<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.quangdo.model.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
		<h1>Displaying Category List</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>ID</b></th>
          <th><b>NAME</b></th>
         </tr>
        
        <%ArrayList<Category> categorys = 
            (ArrayList<Category>)request.getAttribute("data");
        for(Category c: categorys){%>
        <%-- Arranging data in tabular form
        --%>
            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getName()%></td>
         
            </tr>
            <%}%>
        </table> 
        <hr/>

</body>
</html>