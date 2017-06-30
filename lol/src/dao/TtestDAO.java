package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBConn2;

public class TtestDAO {

	/*
	 * public boolean insertTest() { try { String writer = "4"; Connection con =
	 * DBConn2.getCon(); String sql = "select * from user_info where num=?";
	 * ps.setString(1, writer); ResultSet rs = ps.executeQuery(); if (rs.next())
	 * { sql = "INSERT INTO TEST(TITLE, CONTENT, WRITER, REG_DATE)"; sql +=
	 * " values(?,?,?,?)"; ps = con.prepareStatement(sql); ps.setString(1,
	 * "게이물"); ps.setString(2, "내 '용'"); ps.setString(3, writer); Date d = new
	 * Date(); SimpleDateFormat sdt = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); ps.setString(4, sdt.format(d));
	 * int result = ps.executeUpdate(); if (result == 1) { return true; } } else
	 * { System.out.println(writer + "번호를 가진 사람이 유저인포테이블에 없어요 자시가!!"); }
	 * DBConn2.closeCon(); } catch (Exception e) { e.printStackTrace(); } return
	 * false; }
	 */
	public List<Map> selectTest() {
		List<Map> testList = new ArrayList<Map>();
		try {
			Connection con = DBConn2.getCon();

			String sql = "SELECT T.*, UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";
			sql += " WHERE T.WRITER = UI.NUM;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Map hm = new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getString("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				hm.put("id", rs.getString("id"));
				hm.put("name", rs.getString("name"));
				testList.add(hm);
			}
			DBConn2.closeCon();
			return testList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateTest() {
		return true;
	}

	public boolean deleteTest() {
		try {
			String title = "게시물4";
			Connection con = DBConn2.getCon();
			String sql = "delete from test where title = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement(sql);
				int result = ps.executeUpdate();
				if (result == 1) {
					return true;
				}
			} else {
				System.out.println("응그런거없어");
			}
			DBConn2.closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		TtestDAO tdao = new TtestDAO();
		// if (tdao.insertTest()) {
		// System.out.println("오~~~ 테스트테이블에 입력이 잘 되었습니다.");
		// }
		if (tdao.deleteTest()) {
			System.out.println("선택하신 글이 삭제됨");
		}

		// List<Map> list = tdao.selectTest();
		// for(Map m : list){
		// System.out.println(m);
		// }
	}
}
