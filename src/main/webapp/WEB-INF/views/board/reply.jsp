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
	<h1>${board} Reply Page</h1>


<div class="container-fluid">
	
		<form class="col-md-6 mx-auto" action="./reply" method="post" >
		  <input type="hidden" name="num" value="${param.num}">	
		  <div class="mb-3">
		    <label for="title" class="form-label">TITLE</label>
		    <input type="text" class="form-control" name="title" id="title" placeholder="Enter Title">
		  </div>
		  
		  <div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type="text" class="form-control" name="writer" id="writer" placeholder="Enter Writer">
		  </div>
		  
		  <div class="mb-3">
		   <label for="exampleFormControlTextarea1" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="exampleFormControlTextarea1" rows="6"></textarea>
		  </div>
		 	
		  <button type="submit" class="btn btn-primary">REPLY</button>
		</form>
	
</div>

</body>
</html>