package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn;

public class UserService {

	public boolean insertUser(HashMap<String, String> hm){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "insert into user_info(usernum, userid, username, age, address,hp1,hp2,hp3,userpwd)";
			sql += " values(?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("usernum"));
			ps.setString(2, hm.get("userid"));
			ps.setString(3, hm.get("username"));
			ps.setString(4, hm.get("age"));
			ps.setString(5, hm.get("address"));
			ps.setString(6, hm.get("hp1"));
			ps.setString(7, hm.get("hp2"));
			ps.setString(8, hm.get("hp3"));
			ps.setString(9, hm.get("userpwd"));
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteUser(HashMap<String, String> hm){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "delete from user_info where usernum=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("usernum"));
			int result = ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public String checkPwd(String pwd1, String pwd2){
		if(pwd1.equals(pwd2)){
			return "로긘했다긔";
		}
		return "븨번틀렸다긔";
	}
	public String loginUser(HashMap<String, String> hm){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn.getCon();
			String sql = "select userpwd from user_info where userid=?";			
			ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("userid"));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String userpwd = rs.getString("userpwd");
				return checkPwd(userpwd, hm.get("userpwd"));		
			}
			
		} catch (Exception e) {
			
		}
		return "긔런 아이듸 없다긔";
}


	
	public List<Map> selectUser(HashMap<String, String> hm){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select usernum,userid,username,age,address,hp1,hp2,hp3,userpwd from user_info";
			if(hm.get("name")!=null){
				sql += " where username like ?";
			}
			con = DBConn.getCon();
			ps = con.prepareStatement(sql);
			if(hm.get("name")!=null){
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			List userList = new ArrayList();
			while(rs.next()){
				HashMap hm1 = new HashMap();
				hm1.put("usernum", rs.getString("usernum"));
				hm1.put("userid", rs.getString("userid"));
				hm1.put("username", rs.getString("username"));
				hm1.put("age", rs.getString("age"));
				hm1.put("address", rs.getString("address"));
				hm1.put("hp1", rs.getString("hp1"));
				hm1.put("hp2", rs.getString("hp1"));
				hm1.put("hp3", rs.getString("hp3"));
				hm1.put("userpwd", rs.getString("userpwd"));
				userList.add(hm1);
			}
			return userList;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
