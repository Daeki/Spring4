/**
 *  boardFile.js
    최대 5개까지 만 추가 가능
 */
 
  let files = '<div class="input-group mb-3">';
 files = files + '<input type="file" name="files" class="form-control">';
 files = files + '  <button class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';
 let count=0;
 //let index=0;
 
 function setCount(c){
	count = c;
}

function updateCount(){
	count--;
}
 
 
 $('#fileAdd').click(function(){
/*	index++;
 let files = '<div class="input-group mb-3" id="del'+index+'">';
 files = files + '<input type="file" class="form-control">';
 files = files + '  <button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';*/
	if(count<5){
		count++;
		$("#fileAddResult").append(files);
	}else {
		alert('최대 5개 까지만 가능');
	}
});

$("#fileAddResult").on('click', '.del' ,function(){
/*	let num = $(this).attr('data-btn-id');
	$("#del"+num).remove();*/
	
	$(this).parent().remove();
	
	count--;
	
});

/*$(".del").click(function(){
	alert('test');
});*/


