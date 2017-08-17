<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead> 
			<tr> 
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">업체 등록 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">업체명</td>
				<td class="col-md-4"><input type="text" name="giName" id="viName"></td>
			</tr>
			<tr>
				<td>업종</td>
				<td><input type="text" name="viDesc" id="viDesc"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="viAddress" id="viAddress"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="viPhone" id="viPhone"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="btnInsert" class="btn btn-primary" 	type="button">업체등록</button>
					<button id="goList" class="btn" 	type="button">취소</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->

<script>
	$("#btnInsert").click(function(){
		var params = {};
		params["command"] = "insert";
		params["viName"] = $("#viName").val();
		params["viDesc"] = $("#viDesc").val();
		params["viAddress"] = $("#viAddress").val();
		params["viPhone"] = $("#viPhone").val();
		movePageWithAjax(params, "/list.vendor", callbackInsert);
	})
	
	function callbackInsert(result){
		alert(result.msg);
		location.href = result.url;
	}
	
	
</script>
</body>
</html>