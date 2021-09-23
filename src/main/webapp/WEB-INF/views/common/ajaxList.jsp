<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-dark table-striped">

<c:forEach items="${comments}" var="comment">
	<tr>
		<td>${comment.commentNum}</td>
		<td>${comment.contents}</td>
		<td>${comment.writer}</td>
		<td>${comment.regDate}</td>
	</tr>

</c:forEach>
</table>