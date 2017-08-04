<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.test.dto.Cal"%>

<%
	 Gson g = new Gson();
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> vendorList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn.getCon();
		String sql = "select vinum, viname from vendor_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("vinum", rs.getString("vinum"));
			rhm.put("viname", rs.getString("viname"));
			vendorList.add(rhm);
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

String json = g.toJson(vendorList);
System.out.println(json);
out.print(json);
	%>