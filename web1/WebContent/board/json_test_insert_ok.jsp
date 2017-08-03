<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>

<%
	Gson g = new Gson();
HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
String numStr = hm.get("num");
int num = Integer.parseInt(numStr);
String jttext = hm.get("jttext");

Connection con  = null;
PreparedStatement ps = null;
ArrayList<Map<String, String>> jtList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn.getCon();
		String sql = "insert into json_test(num, jttext)";
		sql += "values(?,?)";

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Map<String, String> rhm = new HashMap<String, String>();
			rhm.put("num", rs.getString("num"));
			rhm.put("jttext", rs.getString("jttext"));

			jtList.add(rhm);
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally {
		if (ps != null) {
			ps.close();
			ps = null;
		}
		DBConn.closeCon();
	}

	String json = g.toJson(jtList);
	System.out.println(json);
	out.print(json);
%>