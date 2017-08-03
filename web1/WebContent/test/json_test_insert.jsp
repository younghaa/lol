<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.test.dto.UserInfo"%>

<body>
	<div class="container">
		<form method="get"
			action="<%=rootPath%>/test/json_test_insert_ok.jsp">
			<table id="table" data-height="460"
				class="table table-bordered table-hover">

				<thead>
					<tr>
						<th data-field="num" class="text-center">번호 : <input
							type="text" name="num" id="num" /></th>
					</tr>
					<tr>
						<th data-field="jttext" class="text-center">아무말 : <textarea
								name="jttext" id="jttext" /></textarea></th>
					</tr>
				</thead>
				<tbody id="result_tbody">
				</tbody>
				</form>
			</table>
	</div>
	<input type="submit" value="저장하기" />
	<div id="result_div" class="container"></div>
</body>