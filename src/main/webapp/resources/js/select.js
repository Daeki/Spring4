/**
 *   select.js
 */
 
 const c1 = document.getElementsByClassName('c1');
 const btn = document.getElementById('btn');
 
 
 btn.addEventListener('click', function(){
	
	for(let c of c1){
		c.checked=true;
	}
	
		
});
 
//let t=1;//전역변수

for(let ch of c1){
	if(ch.checked){
		ch.checked= !ch.checked;
	}else {
		ch.checked= !ch.checked;
	}
}


 for(let ch of c1){//ch = 전역변수
	ch.addEventListener('click', function(){
		alert(ch.checked);
	//	let t2=2; //지역변수
	});
}


