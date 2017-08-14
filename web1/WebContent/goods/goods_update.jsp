<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead>
			<tr> 
				<th colspan="3" class="text-center"><h5 class="form-signin-heading">상품수정 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2" align="center" >상품번호</td>
				<td class="col-md-4" colspan="2" align="center"><%=request.getParameter("giNum") %></td> 
				</tr>
			<tr>
				<td class="text-center">상품이름</td>
				<td><input type="text" name="giName" id="giName" align="center"></td>
			</tr> 
			<tr> 
				<td class="text-center">상품설명</td>
				<td><input type="text" name="giDesc" id="giDesc" align="center"></td>
			</tr> 
			<tr>
				<td class="text-center">생산자번호</td>
				<td colspan="2"class="text-center"><%=request.getParameter("viNum") %></td> 
			</tr>
			<tr>
				<td class="text-center">생산자이름</td>
				<td colspan="2"class="text-center"><%=request.getParameter("viName") %></td> 
			</tr>
			</thead>
			</table>
			<table align="center" data-height="460"	class="table-hovor"> 
			<tr>
				<th colspan="3" class="text-center">
					<button id="btnUpdate" class="btn btn-md-3 btn-primary"  type="button">수정하기</button>
				</th> 
				<td>&nbsp;&nbsp; </td> <!--칸띄우기-->
				<th colspan="3" class="text-center">
					<button id="btnGoList" class="btn btn-md-3 btn-primary"  type="button">취소</button>
				</th>
			</tr>
			</table>
	</div>
	<!-- /container -->
<script>
$("#btnUpdate").click(function(){
	var isUpdate = confirm("수정 하시겠습니까?");
	if(isUpdate){
		var params = {};
		params["giNum"] = "<%=request.getParameter("giNum")%>";
		params["giName"] = "<%=request.getParameter("giName")%>";
		params["giDesc"] = "<%=request.getParameter("giDesc")%>";
		params["viNum"] = "<%=request.getParameter("viNum")%>";
		params["viName"] = "<%=request.getParameter("viName")%>";
		params["command"] = "view";
		var page = {};
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callBackView);
	}
});

function callBackView(result){
	alert(result.msg);
	if(result.url!=""){}
		location.href = result.url + "?nowPage=" + result.page.nowPage;
	}

$("#btnUpdate_ok").click(function(){
	location.href="/goods/goods_update.jsp?nowPage=" + <%=request.getParameter("nowPage")%> + "&giNum=" + <%=request.getParameter("giNum")%>
});
$("#btnGoList").click(function(){
	location.href="/goods/goods_view.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});

</script>
</body>
</html>