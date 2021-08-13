<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
  		<form method="POST" action="${pageContext.request.contextPath}/Search">
         <table border="0">
            <tr>
               <td><input type="submit" value= "Search" /></td>
               <td><input type="text" name="string" value= "${user.password}" /> </td>
            </tr>
         </table>
      </form>
      <div style="float: left;padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/BookList">LIBRARY</a>
   |
   <a href="${pageContext.request.contextPath}/CategoryList">CATEGORY</a>
   |
   <a href="${pageContext.request.contextPath}/UserInfor">MY ACCOUNT</a>
 
</div> 
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${loginedUser.name}</b>
   <br/>
 
  </div>
 
</div>