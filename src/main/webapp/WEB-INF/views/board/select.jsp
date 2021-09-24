<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more {
		cursor: pointer;
	}
	

</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<div class="container-fluid col-md-8">
		<h1>${board}Select Page 1</h1>
		<h3>NUM:${dto.num}</h3>
		<h3>Title:${dto.title}</h3>
		
		<div>
			${dto.contents}
		</div>
		
		
		<h3>Writer:${dto.writer}</h3>
		<h3>DATE:${dto.regDate}</h3>
		<h3>HITS:${dto.hits}</h3>
		
	<c:forEach items="${dto.files}" var="f">
		<div>
		<a href="./down?fileName=${f.fileName}">${f.oriName}</a>	
		</div>
	</c:forEach>
	
	<hr>
	<!-- comment list -->
	<div id="commentList" data-board-num="${dto.num}">
		
	
	</div>
	
	
	<div>
		<div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type="text" class="form-control" readonly="readonly" value="${member.id}" name="writer" id="writer" placeholder="Enter Writer">
		  </div>
		  
		  <div class="mb-3">
		   <label for="contents" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="6"></textarea>
		  </div>
		 
		 <button type="button" id="comment" class="btn btn-primary">WRITE</button>
	</div>
	
	
	
	<hr>
	
		
	
	<c:if test="${not empty member and member.id eq dto.writer}">
		<a href="./delete?num=${dto.num}">DELETE</a>
		<a href="./update?num=${dto.num}">UPDATE</a>
	</c:if>
	
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	</div>

<c:import url="../temp/boot_footer.jsp"></c:import>



<script type="text/javascript">
	getCommentList(1);
	
	//update
	$("#commentList").on("click", ".commentUpdate", function() {
		console.log('update');
		let num = $(this).attr("data-comment-update");
		let content= $("#content"+num).html();
		let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="6">';
		ta = ta+content.trim() +'</textarea>';
		ta = ta + '<button type="button" id="" class="btn btn-primary">update</button>';
		ta = ta + '<button type="button" id="" class="btn btn-primary">Cancel</button>';
		 $("#content"+num).html(ta);
		
		
	});
	
	//Del click event
	$("#commentList").on("click", ".commentDel", function() {
		let commentNum = $(this).attr("data-comment-del");
		console.log(commentNum);
		$.ajax({
			type:"POST",
			url : "./commentDel",
			data: {
				commentNum:commentNum
			},
			success:function(result){
				result=result.trim();
				
				if(result>0){
					alert("삭제성공");
					getCommentList(1);
				}else {
					alert("삭제실패");
				}
				
			},
			error:function(){
				alert('삭제에 실패');
			}
			
		});
		
		
	});
	
	
	$("#commentList").on("click", ".more", function(){
		//data-comment-pn 값을 출력
		let pn = $(this).attr("data-comment-pn");
		getCommentList(pn);
	});
	
	
	function getCommentList(pageNumber) {
		let num = $("#commentList").attr("data-board-num");
		$.ajax({
			type: "GET",
			url : "./getCommentList",
			data: {
				num:num,
				pn : pageNumber
				
			},
			success: function(result){
				result=result.trim();
				$("#commentList").html(result);
			},
			error:function(xhr, status, error){
				console.log(error);
			}
			
		});
		
	}


	$("#comment").click(function(){
		let writer = $("#writer").val();
		let contents = $("#contents").val();
		$.post('./comment', {num:'${dto.num}', writer:writer, contents:contents}, function(result){
			console.log(result.trim());
			
			$("#contents").val('');
			getCommentList();
			
		});
		
	});
</script>	
	

</body>
</html>