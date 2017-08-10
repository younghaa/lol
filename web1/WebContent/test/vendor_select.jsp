<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.test.dto.Cal"%>

<%
	int rowCnt = 10;
	int nowPage = 1;
	int blockCnt = 10;
	int totalPageCnt = 0;
	int totalBlockCnt = 0;
	int totalCnt = 0;
	
    Gson g = new Gson();
    HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
    if(hm!=null && hm.get("nowPage")!=null){
    	nowPage = Integer.parseInt(hm.get("nowPage"));
    }
    
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> vendorList = new ArrayList<Map<String, String>>();
	ArrayList<Map<String, String>>goodsList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn.getCon();
		String sql = "select vinum, viname from VENDOR_INFO;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			vendorList.add(rhm);
		}
		sql = "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";	
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			totalCnt = rs.getInt(1);
		}
		if(totalCnt !=0){
			int mod = totalCnt % rowCnt;
			totalPageCnt = totalCnt / rowCnt;
			if(mod!=0){
				totalPageCnt +=1;
			}
		}
		
		if(totalPageCnt!=0){
			int mod = totalPageCnt % blockCnt;
			totalBlockCnt = totalPageCnt / blockCnt;
			if(mod!=0){
				totalBlockCnt +=1;
			}
		}
		System.out.println(totalCnt);
		System.out.println(totalPageCnt);
		System.out.println(totalBlockCnt);
		sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.viname from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
		sql += " order by gi.ginum ";
		sql += " limit ?,?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, (nowPage-1)*rowCnt);
		ps.setInt(2,rowCnt);
		rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("ginum", rs.getString("ginum"));
			rhm.put("giname", rs.getString("giname"));
			rhm.put("gidesc", rs.getString("gidesc"));
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			goodsList.add(rhm);
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}
HashMap<String, Integer> pageHm = new HashMap<String, Integer>();
pageHm.put("nowPage", nowPage);
pageHm.put("totalPageCnt", totalPageCnt);
pageHm.put("totalBlockCnt", totalBlockCnt);
pageHm.put("blockCnt", blockCnt);
pageHm.put("totalCnt", totalCnt);

HashMap resultHm = new HashMap();
resultHm.put("vendorList", vendorList);
resultHm.put("goodsList", goodsList);
resultHm.put("pageInfo", pageHm);

String json = g.toJson(resultHm);
out.print(json);
	%>
	
	
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