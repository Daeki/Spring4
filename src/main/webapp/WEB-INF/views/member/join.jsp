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
	<h1 class="col-md-6 mx-auto my-5">Join Page</h1>
	<form id="frm" action="join" method="post" enctype="multipart/form-data"  class="col-md-6 mx-auto" >
  
  <div class="mb-3">
    <label for="text" class="form-label">ID</label>
    <input type="text" class="form-control put" id="id" name="id"> 
    <button type="button" id="idCheck">ID중복확인</button>
	<div id="idResult"></div>    
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control put pw" id="pw1" name="pw">
  </div>

  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password 확인</label>
    <input type="password" class="form-control put pw" id="pw2" name="pwCheck" placeholder="password를 한번더 입력하세요">
  	<div id="warnPw" style="color:red;"></div>
  </div>
  
  <div class="mb-3">
    <label for="text" class="form-label">Name</label>
    <input type="text" class="form-control put" id="name" name="name">
  <!--   <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
  </div>
  
  <div class="mb-3">
    <label for="text" class="form-label">Phone</label>
    <input type="tel" class="form-control put" id="phone" name="phone" placeholder="01012345678">
  <!--   <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control put" id="email" name="email" aria-describedby="emailHelp" placeholder="email@email.com">
  <!--   <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
  </div>
  
  
  <div class="mb-3" id="f">
    <label for="photo" class="form-label">Photo</label>
    <input type="file" class="form-control put" id="photo" name="photo" aria-describedby="emailHelp">
  </div>
  
  
   <div class="mb-3 my-4">
    <label class="form-label"></label>
  	<button id="btn" type="submit" class="btn btn-primary">Join</button>
  </div>
  
</form>
<!-- <script type="text/javascript" src="../resources/js/join.js"></script>
<script type="text/javascript" src="../resources/js/file.js"></script> -->
</body>
</html>