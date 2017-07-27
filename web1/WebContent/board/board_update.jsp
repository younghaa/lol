<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.UserInfo" %>
<%

%>
<body>
<form method="get" action="<%=rootPath %>/board/board_insert_ok.jsp">
제목 : <input type="text" name="bititle" id="bititle"/></br>
내용 : <textarea name="bicontent" id="bicontent"></textarea><br/>
작성자 : <input type="text" name="creusr" id="creusr" value="<%=userId%>"/><br/>
비밀번호 : <input type="password" name="bipwd" id="bipwd"/><br/>
<input type="submit" value="수정완료"/>
</form>
</body>
</html>