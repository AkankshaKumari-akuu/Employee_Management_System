/**
 * 
 */
function validateForm() {
	var empName = document.getElementById("empName").value;
	var m = "!~@#$%^&*(){}-=+[]|.:";
	if (empName.length <= 2) {
		document.getElementById("Message").innerHTML = "**Name must have more than 2 char";
		return false;
	}
	for (var i = 0; i < empName.length; i++) {
		if (m.indexOf(empName.charAt(i)) != -1) {
			document.getElementById("Message").innerHTML = "**Don't use special char";
			return false;
		}
	}
	
	var bp = document.getElementById("bp").value;
	if(isNaN(bp)){
		document.getElementById("Message2").innerHTML = "**Please use number";
			return false;
	}
	return true;
}