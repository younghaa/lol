<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="vi.vinum"  class="text-center">번호</th>
					<th data-field="vi.viname"  class="text-center">회사이름</th>
					<th data-field="vi.videsc"  class="text-center">회사종류</th>
					<th data-field="vi.viaddress"  class="text-center">회사주소</th>
					<th data-field="vi.viphone"  class="text-center">연락처</th>
					<th data-field="vi.vicredat"  class="text-center">작성일자(회사정보)</th>
					<th data-field="vi.vicretim"  class="text-center">작성시간(회사정보)</th>
					<th data-field="gi.ginum"  class="text-center">제품번호</th>
					<th data-field="gi.giname"  class="text-center">제품이름</th>
					<th data-field="gi.gidesc"  class="text-center">제품정보</th>
					<th data-field="gi.gicredat"  class="text-center">생산일자(제품정보)</th>
					<th data-field="gi.gicretim"  class="text-center">출고시간(제품정보)</th>
				</tr>
			</thead>
		
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
	<select id="s_vendor">
<option value="op"> 회사선택 </option>
</select>
<input type="button" id="getVendorGoods" value="리스트호출"/>
<div id="result_div" class="container"></div>
<script>
$(document).ready(function(){
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/vendor_select.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : null
	    	    ,   success : function(results){
	    	    	for(var i=0, max=results.length;i<max;i++){
		    	    	var result=results[i];
		    	        	$("#s_vendor").append("<option value='"+result.vinum+"'>"+result.viname+"</option>");
	    	    }
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		complete : function(e) {
	    		}
	    		};
	$.ajax(a);
});

$("#getVendorGoods").click(function(){
	var op = $("#op").val();
	var param = {};
	param["op"] = op;
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/vendorgoods_select.jsp"
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
	    		complete : function(e) {
	    		}
	    		};
	$.ajax(a);
});
</script>