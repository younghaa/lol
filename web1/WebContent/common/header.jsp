<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<%!
public void printStr(String str){
	System.out.println("adsfsfad");
}
%>
<%
String userId = (String) session.getAttribute("userid");
String userName = "";
int age =  0;
String address =  "";
String hp1 =  "";
String hp2 =  "";
String hp3 =  "";

boolean login = false;
if(userId!=null){
	userName =  (String) session.getAttribute("username");
	age =  (int) session.getAttribute("age");
	address =  (String) session.getAttribute("address");
	hp1 =  (String) session.getAttribute("hp1");
	hp2 =  (String) session.getAttribute("hp2");
	hp3 =  (String) session.getAttribute("hp3");
	login = true;
}
String rootPath = request.getContextPath();
Date toDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String toDateStr = sdf.format(toDate); 
String init = request.getParameter("init");
String defaultUrl = "";
if(init==null && !login){
	defaultUrl = rootPath + "/user/login.jsp?init=2";
	response.sendRedirect(defaultUrl);
}
String nowUrl = request.getRequestURI();
String loginStr = "로그인";
if(login){
	loginStr = "로그아웃";
}String version = "1.3.2";
%>
<script src="<%=rootPath%>/js/jquery-3.2.1.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap-table.js?version=<%=version%>"></script>
<script src="<%=rootPath%>/ui/common.js?version=<%=version%>"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/common.css?version=<%=version%>"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-table.css?version=<%=version%>"/>
<script>
var rootPath = "<%=rootPath%>";
 $(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
}) 
function doMovePage(pageId){
	var url = "<%=rootPath%>";
	if(pageId=="board"){
		url += "/board/board_select.jsp";
	}else if(pageId=="main"){
		url += "/main.jsp";
	}else if(pageId=="insertBoard"){
		url += "/board/board_insert.jsp";
	}else if(pageId=="cal"){
		url += "/test/cal_select.jsp";
	}else if(pageId=="jti"){
		url += "/test/json_test_insert.jsp";
	}
	location.href=url;	
}
 function alertOp(){
		alert($("#op").val());
	}
</script>

<div class="navbar navbar-defaul navbar-fixed-top">
        <a class="navbar-brand" >IOT_HOME</a>
      </div>
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" ><a href="/main.jsp" >MAIN</a></li>
        <li role="presentation"><a href="/board/board_select.jsp" >게시판</a></li>
        <li role="presentation"><a href="/user/user_info.jsp">유저정보</a></li>
        <li role="presentation"><a href="/role/role_select.jsp">권한정보</a></li>
         <li role="presentation"><a href="/goods/goods_list.jsp">제품관리</a></li>
        <li><a href="/user/logout_ok.jsp"><%=loginStr%></a></li>
           </ul>

    

      
      