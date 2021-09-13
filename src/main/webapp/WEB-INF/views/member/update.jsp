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
	<h1 class="col-md-6 mx-auto my-5">Update Page</h1>
	<form id="frm" action="update" method="post"  class="col-md-6 mx-auto" >
  	
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password</label>
	    <input type="password" class="form-control put pw" id="pw1" value="${member.pw}" name="pw">
	  </div>
	
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password 확인</label>
	    <input type="password" class="form-control put pw" id="pw2" name="pwCheck" placeholder="password를 한번더 입력하세요">
	  	<div id="warnPw" style="color:red;"></div>
	  </div>
  
  
	  <div class="mb-3">
	    <label for="text" class="form-label">Phone</label>
	    <input type="tel" class="form-control put" id="phone" name="phone" value="${member.phone}" placeholder="01012345678">
	  <!--   <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
	  </div>
  
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email</label>
	    <input type="email" class="form-control put" id="email" name="email" value="${member.email}" aria-describedby="emailHelp"  placeholder="email@email.com">
	  <!--   <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
	  </div>
  
	   <div class="mb-3 my-4">
	    <label class="form-label"></label>
	  <button id="btn" type="submit" class="btn btn-primary">Update</button>
	    
  </div>
  
</form>
<script type="text/javascript" src="../resources/js/join.js"></script>
</body>
</html>