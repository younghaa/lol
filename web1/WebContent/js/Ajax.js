/**
 * 
 */
var str = "name,id,pwd";
var strs = str.split(",");
var param = "";
for (var i = 0; i < strs.length; i++) {
	var value = document.getElementById(strs[i]).value;
	param += "&" + strs[i] + "=" + value;
}
var au = new AjaxUtil("/login.action", "name,id,pwd");
var AjaxUtil = function a(url, arrParams, method, aSync) {
	this.fAction = url;
	this.fMethod = method ? method : "get";
	var params = "?action = LOGIN&id=" + encodeURIComponent(userid);
	this.fASync = aSync ? aSync : true;
	xmlHttpObj.onreadystatechange = function() {
		if (xmlHtmlObj.readyState == 4 && xmlHttpObj.status == 200) {
			var result = decodeURIComponent(xmlHttpOnj.responseText);
			if (result == "success") {
				location.href = "../user/welcome/jsp"
			} else {
				alert(result);
			}
		}
	}
	xmlHttpObj.open(method, url + params, sync);
	if (method == "post") {
		xmlHttpObj.setrequestHeader("Content-type",	"application/x-www.-form-urlencoded");
	}
	xmlHttpObj.send(params);
}