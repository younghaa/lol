<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>
<script>
alert("로그아웃 하셨습니다");
location.href= "<%=rootPath%>/main.jsp";

</script>