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
String jttext = hm.get("jttext");
int num1 = Integer.parseInt(numStr);

Connection con  = null;
PreparedStatement ps = null;
int insertResult =0;
try{
	con  = DBConn.getCon();
	String sql = "insert into cal(num, jttext) values(?,?)";
	ps = con.prepareStatement(sql);
	ps.setString(1,numStr);
	ps.setString(2,jttext);
	insertResult = ps.executeUpdate();
	if(insertResult==1){
		con.commit();
	}
}catch(Exception e){
	out.println(e);
}finally{
	ps.close();
	DBConn.closeCon();
}

HashMap<String, Integer> resultMap = new HashMap<String,Integer>();
resultMap.put("insert",insertResult);
String json = g.toJson(resultMap);
System.out.println(json);
out.print(json);
%>