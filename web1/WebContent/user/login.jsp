<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.UserInfo" %>
<link rel = "stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<body>
<div class="container">
      <form class="form-signin"  action="<%=rootPath%>/user/login_ok.jsp">
        <h2 class="form-signin-heading">로그인하세요</h2>
        <label for="text" class="sr-only">ID</label>
        <input type="text" id="id" name="id"class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">PASSWORD</label>
        <input type="password" name="pwd"id="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> ID 저장하기
          </label>
        </div>
        <button id="button" class="btn btn-lg btn-primary btn-block" type="button">로그인</button>
      </form>

    </div> <!-- /container -->
	<script>
	
	$("button.btn").click(function(){
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		var param = {};
		param["userId"] = id;
		param["userPwd"] = pwd;
		param = JSON.stringify(param);
		var a = { 
		        type     : "POST"
		    	    ,   url      : "/user/login_ok.jsp"
		    	    ,   dataType : "json" 
		    	    ,   beforeSend: function(xhr) {
		    	        xhr.setRequestHeader("Accept", "application/json");
		    	        xhr.setRequestHeader("Content-Type", "application/json");
		    	    }
		    	    ,   data     : param
		    	    ,   success : function(result){
		    	    	alert(result.msg);
		    	    	if(result.login=="ok"){
		    	    		location.href = "<%=rootPath%>/main.jsp";
		    	    	}else{
		    	    		$("#id").val("");
		    	    		$("#pwd").val("");
		    	    	}
		    	    }
		    	    ,   error : function(xhr, status, e) {
		    		    	alert("에러 : "+e);
		    		},
		    		done : function(e) {
		    		}
		    		};
		$.ajax(a);
	});
</script>
</body>
</html>

<%-- <link rel = "stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<body>
<jsp:include page="/common/top.jsp" flush="false">
<jsp:param name="login" value="<%=login%>"/>
</jsp:include>
<div class="container">

      <form class="form-signin"  action="<%=rootPath%>/user/login_ok.jsp">
        <h2 class="form-signin-heading">로그인하세요</h2>
        <label for="text" class="sr-only">ID</label>
        <input type="text" id="id" name="id"class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">PASSWORD</label>
        <input type="password" name="pwd"id="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> ID 저장하기
          </label>
        </div>
        <button id="button" class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>

    </div> <!-- /container -->
<script>

/* $("button").click(function(){
	alert(1);
});
$("#btn2").click(function(){
	alert(2);
}); */
</script>

</body>
</html> --%>