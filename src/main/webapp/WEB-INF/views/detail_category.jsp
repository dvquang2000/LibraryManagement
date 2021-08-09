<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.quangdo.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
		<h1>Displaying Book List</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>ID</b></th>
          <th><b>Title</b></th>
          <th><b>Author</b></th>
          <th><b>Publish Year</b></th>
          <th><b>Category</b></th>
         </tr>
        
        <%ArrayList<Book> books = 
            (ArrayList<Book>)request.getAttribute("data");
        for(Book b:books){%>
        <%-- Arranging data in tabular form
        --%>
            <tr>
                <td><%=b.getId()%></td>
                <td><%=b.getTitle()%></td>
                <td><%=b.getAuthor()%></td>
                <td><%=b.getPublished_year()%></td>
                <td><%=b.getCategoryId()%></td>
            </tr>
            <%}%>
        </table> 
        <hr/>

</body>
</html>