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
var thisBlockCnt=0;
var thisNowPage=0;
var thisTotalPage=0;
function callback(results){
	    	    	var vendorList = results.vendorList;
	    	    	var goodsList = results.goodsList;
	    	    	var pageInfo = results.pageInfo;
	    	    	
	    	    	var blockCnt = new Number(pageInfo.blockCnt);
	    	    	thisBlockCnt = blockCnt;
	    	    	var nowPage = new Number(pageInfo.nowPage);
	    	    	thisNowPage = nowPage;
	    	    	var startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
	    	    	var endBlock = startBlock+blockCnt-1;
	    	    	var totalPageCnt = new Number(pageInfo.totalPageCnt);
	    	    	thisTotalPage = totalPageCnt;
	    	    	if(endBlock>totalPageCnt){
	    	    		endBlock=totalPageCnt;
	    	    	}
	    	    	
	    	    	setPagination(startBlock, endBlock, pageInfo.nowPage,"page");
	    	    	
	    	    	for(var i=0, max = vendorList.length; i<max;i++){
		    	        	$("#s_vendor").append("<option value='"+ vendorList[i].vinum+"'>"+vendorList[i].viname+"</option>");
	    	    }
	    	    	 $('#table').bootstrapTable('destroy');
	    	    	$('#table').bootstrapTable({
	    	            data: goodsList
	    	        });
	    	    	setEvent();
	    	    }
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "1";
	goPage(params, "/test/vendor_select.jsp", callback);
});
	function setEvent(){
		$("ul[class='pagination']>li>a").click(function(){
			var goPageNum = new Number(this.innerHTML);
	if(isNaN(goPageNum)){
		if(this.innerHTML=="◀"){
			thisNowPage -= thisBlockCnt;
		}else if(this.innerHTML=="◀◀"){
			thisNowPage = 1;
		}else if(this.innerHTML=="▶"){
			thisNowPage += thisBlockCnt;
		}else if(this.innerHTML=="▶▶"){
			thisNowPage = thisTotalPage;
		}
		if(thisNowPage<=0){
			thisNowPage=1;
		}else if(thisNowPage>thisTotalPage){
			thisNowPage = thisTotalPage;
		}
	goPageNum = thisNowPage;
	}
	var params = {};
	params["nowPage"] = "" + goPageNum;
	goPage(params,"/test/vendor_select.jsp", callback);
		})
	}


</script>
</body>
</html>