<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>
</head>
<style>
div{
border-style: solid;
    border-color: red;
}
</style>
<body>
<p>get parameter방식</p>
<form action="test.formtest" method="get">
	아이디 : <input type="text" name="id1"><br>
	비밀번호 : <input type="text" name="pwd2"><br>
	<input type="submit" value="전송">
</form>

<p>POST JSON방식</p>
<form action="test.formtest" method="post" id="testForm">
	아이디 : <input type="text" name="id" id="id"><br>
	비밀번호 : <input type="text" name="pwd" id="pwd"><br>
	<input type="button" value="전송" onclick="postTest()">
</form>
<div id="div1">
</div>
<script>
function postTest(){
	var params = {};
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
	/* var params  = $("#testForm").serializeArray();
	params = JSON.stringify(params); 
	alert(params);  */
	$.ajax({ 
		type     : "POST"
    ,   url      : "/test.formtest"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : params
    ,   success : function(result){
	 	var divObj = document.getElementById("div1");
	 	divObj.insertAdjacentHTML("beforeend",result.msg1 + ":" + result.id+"<br>");
	 	divObj.insertAdjacentHTML("beforeend",result.msg2 + ":" + result.pwd+"<br>");
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}
});
}
</script>
</body>
</html>