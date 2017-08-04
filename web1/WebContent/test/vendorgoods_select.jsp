<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>
<%
	 Gson g = new Gson();
	 HashMap<String,String> hm = g.fromJson(request.getReader(), HashMap.class);
	
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> vdList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn.getCon();
		String sql = "select vi.vinum, vi.viname,vi.videsc, vi.viaddress, vi.viphone, vi.vicredat, vi.vicretim,gi.ginum, gi.giname, gi.gidesc, gi.gicredat, gi.gicretim ";
				sql+="from vendor_info as vi , goods_info as gi ";
				sql+="where vi.vinum= gi.vinum";

		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("vi.vinum", rs.getString("vi.vinum"));
			rhm.put("vi.viname", rs.getString("vi.viname"));
			rhm.put("vi.videsc", rs.getString("vi.videsc"));
			rhm.put("vi.viaddress", rs.getString("vi.viaddress"));
			rhm.put("vi.viphone", rs.getString("vi.viphone"));
			rhm.put("vi.vicredat", rs.getString("vi.vicredat"));
			rhm.put("vi.vicretim", rs.getString("vi.vicretim"));
			rhm.put("gi.ginum", rs.getString("gi.ginum"));
			rhm.put("gi.giname", rs.getString("gi.giname"));
			rhm.put("gi.gidesc", rs.getString("gi.gidesc"));
			rhm.put("gi.gicredat", rs.getString("gi.gicredat"));
			rhm.put("gi.gicretim", rs.getString("gi.gicretim"));
			vdList.add(rhm);
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

String json = g.toJson(vdList);
System.out.println(json);
out.print(json);
	%>