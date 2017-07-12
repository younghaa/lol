/**
 * 
 */

function checkValue(fObj) {
	var maxNum = fObj.elements.length;

	var result = "";
	for (var i = 0; i < maxNum; i++) {
		var eObj = fObj.elements[i];
		if ((i + 1) % 2 == 0 && i != maxNum-1) {
			var checkNum=new Number(eObj.value);
			if (isNaN(checkNum)) {
				alert("2,4,6번칸은 숫자를 입력해야 합니다");
				eObj.value="";
				eObj.focus();
				return false;
			}
		}
		if (eObj.value != "전송") {
			result += eObj.value;
	}
	if (i == maxNum - 1) {
		eObj.value = result;
	}
	}
	return false;
	
}