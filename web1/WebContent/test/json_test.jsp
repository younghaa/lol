<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="num"  class="text-center">번호</th>
					<th data-field="jttext"  class="text-center">아무말</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
<input type="button" id="getJsonTest" value="리스트"/>
<input type="button"  value="아무말쓰러가기" onclick="doMovePage('jti')"/>
<div id="result_div" class="container"></div>
<script>
$("#getJsonTest").click(function(){

	var param = {};
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/json_test_select.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){
		    	        $('#table').bootstrapTable({
		    	            data: result
		    	        });
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
