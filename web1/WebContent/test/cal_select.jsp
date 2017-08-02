<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="java.sql.*" %>
<%
	 Gson g = new Gson();
	 HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
	String op = "";
	if(hm!=null){
		op = hm.get("op");
	}
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> calList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn.getCon();
		String sql = "select calnum, num1, num2, op, result from cal where 1=1";

		if(op!=null && !op.equals("")){
			sql += " and op = ?";
		}
		ps = con.prepareStatement(sql);
		if(op!=null && !op.equals("")){
			ps.setString(1,op);
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("calnum", rs.getString("calnum"));
			rhm.put("num1", rs.getString("num1"));
			rhm.put("num2", rs.getString("num2"));
			rhm.put("op", rs.getString("op"));
			rhm.put("result", rs.getString("result"));
			calList.add(rhm);
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

String json = g.toJson(calList);
System.out.println(json);
out.print(json);
	%>