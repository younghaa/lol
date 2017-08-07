<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

	<div class="container">
		<table id="table" data-height="460" class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="ginum"  class="text-center">제품번호</th>
					<th data-field="giname"  class="text-center">제품이름</th>
					<th data-field="gidesc"  class="text-center">제품정보</th>
					<th data-field="vinum"  class="text-center">생산자번호</th>
					<th data-field="viname"  class="text-center">회사이름</th>							
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
	<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page">
	</ul>
	<select id="s_vendor">
<option value="op"> 회사선택 </option>
</select>
<input type="button" id="getVendorGoods" value="리스트호출"/>
<div id="result_div" class="container"></div>
<script>
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "101";
	params = JSON.stringify(params);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/vendor_select.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : params
	    	    ,   success : function(results){
	    	    	var vendorList = results.vendorList;
	    	    	var goodsList = results.goodsList;
	    	    	var pageInfo = results.pageInfo;
	    	    	
	    	    	var pageStr="<li><a>◀◀</a></li>";
	    	    	pageStr+="<li><a>◀</a></li>";
	    	    	var blockCnt = new Number(pageInfo.blockCnt);
	    	    	var nowPage = new Number(pageInfo.nowPage);
	    	    	var startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
	    	    	var endBlock = startBlock+blockCnt-1;
	    	    	var totalPageCnt = new Number(pageInfo.totalPageCnt);
	    	    	if(endBlock>totalPageCnt){
	    	    		endBlock=totalPageCnt;
	    	    	}
	    	    	for(var i=startBlock , max=endBlock; i<=max; i++){
	    	    		if(i==pageInfo.nowPage){
	    	    			pageStr += "<li class='active'><a>" + i + "</a></li>";
	    	    		}else{
	    	    			pageStr += "<li><a>"+ i +"</a></li>";
	    	    		}
	    	    	}
	    	    	pageStr+="<li><a>▶</a></li>";
	    	    	pageStr+="<li><a>▶▶</a></li>";
	    	    	
	    	    	$("#page").html(pageStr);
	    	    	for(var i=0, max = vendorList.length; i<max;i++){
		    	    	var result=vendorList[i];
		    	        	$("#s_vendor").append("<option value='"+ vendorList[i].vinum+"'>"+vendorList[i].viname+"</option>");
	    	    }
	    	    	$('#table').bootstrapTable({
	    	            data: goodsList
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

$("#getVendorGoods").click(function(){
	var op = $("#op").val();
	var param = {};
	param["op"] = op;
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "/test/vendor_select.jsp"
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