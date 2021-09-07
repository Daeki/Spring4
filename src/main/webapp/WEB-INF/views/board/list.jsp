<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<h1>List Page</h1>

<div class="col-md-7 my-2 mx-auto">	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">REGDATE</th>
	      <th scope="col">HITS</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list}" var="dto">
		    <tr>
		      <th scope="row">${dto.num}</th>
		      <td><a href="./select?num=${dto.num}">${dto.title}</a></td>
		      <td>${dto.writer}</td>
		      <td>${dto.regDate}</td>
		      <td>${dto.hits}</td>
		    </tr>
	   </c:forEach>
	  </tbody>
	</table>
	
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
		<a href="./list?pn=${n}">${n}</a>
	</c:forEach>
	
	
	 <a href="./insert" class="btn btn-secondary">ADD</a>
</div>	
	
	
</body>
</html>