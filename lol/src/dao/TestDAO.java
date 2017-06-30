package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import common.DBConn2;

public class TestDAO {

	public boolean insertTest() {
		/*try {
			Connection con = DBConn2.getCon();
			Scanner scan = new Scanner(System.in);
			HashMap<String, String> hm = new HashMap<String, String>();
			System.out.println("TITLE입력");
			hm.put("title", scan.nextLine());
			System.out.println("CONTENT입력");
			hm.put("content", scan.nextLine());
			System.out.println("WRITER입력");
			hm.put("writer", scan.nextLine());
			System.out.println("날짜자동입력");

			String sql = "insert into test(title, content, writer, reg_date)" + "values(?,?,?,now())";

			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1, hm.get("title"));
			prestmt.setString(2, hm.get("content"));
			prestmt.setString(3, hm.get("writer"));
			Date d = new Date(4);
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			prestmt.setString(4,sdt.format(d));
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}*/
		
		try{
			Connection con = DBConn2.getCon();
			String sql = "INSERT INTO TEST(TITLE, CONTENT, WRITER, REG_DATE)";
			sql += " values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "게시물4");
			ps.setString(2, "내용4");
			ps.setString(3, "1");
			Date d = new Date();
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(4,sdt.format(d));
			int result = ps.executeUpdate();
			if(result==1){
				return true;
			} 
			DBConn2.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public List<Map> selectTest() {
/*		List<Map> testList = new ArrayList<Map>();
		try{
			Connection con = DBConn2.getCon();
			
			String sql="select t.*, ui.id, ui.name from user_info as ui, test as t";
			sql+= "where ui.num = t.writer";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title",rs.getString("title"));
				hm.put("content",rs.getString("content"));
				hm.put("writer",rs.getString("writer"));
				hm.put("reg_date",rs.getString("reg_date"));
				hm.put("id",rs.getString("id"));
				hm.put("name",rs.getString("name"));
				testList.add(hm);
			}
			DBConn2.closeCon();
			return testList;
			}catch(SQLException | ClassNotFoundException e){
				e.printStackTrace();
						}
		return null;
	}*/
		List<Map> testList = new ArrayList<Map>();
		try{
			Connection con = DBConn2.getCon();
			
			String sql = "SELECT T.*, UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";
			sql += " WHERE T.WRITER = UI.NUM;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num",rs.getString("num"));
				hm.put("title",rs.getString("title"));
				hm.put("content",rs.getString("content"));
				hm.put("writer",rs.getString("writer"));
				hm.put("reg_date",rs.getString("reg_date"));
				hm.put("id",rs.getString("id"));
				hm.put("name",rs.getString("name"));
				testList.add(hm);
			}
			DBConn2.closeCon();
			return testList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateTest() {
/*		try{
			Connection con = DBConn2.getCon();
			String sql = "update test set writer = '2' where writer like '3'";
			PreparedStatement ps = con.prepareStatement(sql);
		}*/
	
		return true;

}


	public boolean deleteTest() {
		return true;

	}

	public static void main(String[] args) {
		TestDAO tdao = new TestDAO();
		if(tdao.insertTest()){
			System.out.println("테스트테이블에 입력이 잘 되었습니다.");
		}
		
		List<Map> list = tdao.selectTest();
		for(Map m : list){
			System.out.println(m);
		}
	}
}
		
		
/*		TestDAO td = new TestDAO();
		if (td.insertTest()) {
			System.out.println("입력완료");

		}
		List<Map> list = td.selectTest();
		for (Map m : list) {
			System.out.println(m);
		}
	}
}*/
