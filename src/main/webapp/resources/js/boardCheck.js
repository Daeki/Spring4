/**
 * 
 */
 
 const btn = document.getElementById("btn");
 
 btn.addEventListener("click", function(){
	const title = document.getElementById("title");
	const writer = document.getElementById("writer");
	const frm = document.getElementById("frm");
	const t1 = document.getElementById("t_1");
	const w1 = document.getElementById("w_1");
	t1.innerHTML="";
	w1.innerHTML="";
	
	let t = title.value;
	let w = writer.value;
	
	let check=true;
	
	if(t == ""){
		check=false;
		t1.innerHTML="필수 입력";
	}
	
	if(w == ""){
		check=false;
		w1.innerHTML="필수 입력";
	}
	
	if(check){
		frm.submit();
	}else {
		alert('필수 입력...');
	}

	//1
/*	if(t != "" && w != ""){
		alert(true);
	}else {
		alert(false);
	}*/
	

	
	
	
});