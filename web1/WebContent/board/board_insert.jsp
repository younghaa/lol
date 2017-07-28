<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<%-- <%
String bititle = request.getParameter("bititle");//잊어버리지마
String bicontent = request.getParameter("bicontent");//겟파라미터잊어버리지마
String bipwd = request.getParameter("bipwd");//지금보다 더 병신이 되지마
String creusr = request.getParameter("creusr");//리퀘스트(호출).겟빠라미터

Connection con = null;
PreparedStatement ps = null;
try {
	con = DBConn.getCon();
	String sql = "insert into board_info( bititle, bicontent, bipwd, creusr,credat)";//입력해야하는부분만선언해 알간? num은안해도대
	sql += " values(?,?,?,?,now())";	//제목,내용,비번 입력부분이고 아이디는 로그인한거 받아오고 시간은 현재시간
	ps = con.prepareStatement(sql);
	
		ps.setString(1, bititle);			//자바,자바스크립트,JSP 별로선언이 다르니까 다시 잘봐
		ps.setString(2, bicontent);
		ps.setString(3, bipwd);
		ps.setString(4, userId);
		int result = ps.executeUpdate();		//업데이트선언을해줘야해
		if(result==1){
			con.commit();
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally {						//파이널리 클로즈콘 잊지마
		if (ps != null) {
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
}
%>
<script>

</script> --%>
<body>
<jsp:include page="/common/top.jsp" flush="false"></jsp:include>
<div class="container">
<div class="starter-template">

<table border="1" class='table table-bordered table-hover'>
<form method="get" action="<%=rootPath %>/board/board_insert_ok.jsp">
<table class='table table-bordered table-hover'>
<tr>
<td>제목 : </td>
<td><input type="text" name="bititle" id="bititle"/></td>
</tr>
<tr>
<td>내용 : </td>
<td><textarea name="bicontent" id="bicontent"></textarea></td>
</tr>
<tr>
<td>작성자 : </td>
<td><input type="text" name="creusr" id="creusr" value="<%=userId%>"/></td>
</tr>
<tr>
<td>비밀번호 : </td>
<td><input type="password" name="bipwd" id="bipwd"/></td>
</tr>
</form>
</table>
<input type="submit" value="글쓰기"/>
</div>
</div>
</body>