var modal = null;

function modEvt(c){
	modal = document.getElementById("myModal"+c);
	modal.style.display="block";
}

function span_close(c){
	modal.style.display = "none";
}

function myMouseEnter(c){
	
	mouseover = document.getElementById("myMouseEnter"+c);
	mouseover.style.opacity = "1";
	document.getElementById("bookImage"+c).style.opacity ="0.4"
	mouseover.style.display = "block";
}
function myMouseLeave(c){
	
	document.getElementById("bookImage"+c).style.opacity ="1"
	mouseover.style.display = "none";
}
window.addEventListener("click", function(event) {
	if(event.target == modal){
		modal.style.display = "none";
	}
});