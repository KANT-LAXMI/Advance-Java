<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="background-color: cyan"; margin:auto>
<caption>All Books</caption>
<c:forEach var="book" items="${requestScope.bookList}">
<tr>
<td>${book.id}</td>
<td>${book.price}</td>
<td>${book.title}</td>
<td>${book.author}</td>
</tr>
</c:forEach>
</table>
</body>
</html>