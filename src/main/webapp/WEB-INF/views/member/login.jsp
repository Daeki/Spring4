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
	<h1 class="col-md-6 mx-auto my-5">Login Page</h1>
	<form id="frm" action="login" method="post"  class="col-md-6 mx-auto" >
  
  <div class="mb-3">
    <label for="text" class="form-label">ID</label>
    <input type="text" name="id" class="form-control put" id="id">    
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="pw" class="form-control put pw" id="pw1">
  </div>

  
   <div class="mb-3 my-4">
    <label class="form-label"></label>
  	<button id="btn" type="submit" class="btn btn-primary">Login</button>
    
  </div>
  
</form>

</body>
</html>