package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import common.DBConn2;

public class BoardDAO {
	Connection con;

	public void setConnection() throws ClassNotFoundException, SQLException {
		con = DBConn2.getCon();
	}

	public boolean insertBoard() throws SQLException {
		try{
		String sql = "insert into board(title, content, writer,reg_date)values('게시판제목3','게시판내용3',1,now())";
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);
		if (result == 1) {
			con.commit();
			st.close();
			st = null;
			return true;
		}
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateBoard() throws SQLException {
		try{
		String sql = "update board set title='밍밍11' where num='11'";
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);
		if (result == 1) {
			con.commit();
			st.close();
			st = null;
			return true;
		}			

		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean deleteBoard() throws SQLException {
		try{
		String sql = "delete from board where num='28'";
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);
		if (result == 1) {
			con.commit();
			st.close();
			st = null;
			return true;
		}
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		}
		return false;
	}
		
/*	public boolean selectBoard() throws SQLException {
		String sql = "select b.*,ui.ui, ui.name from board as b,user_info as ui, class_info as ci,";
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);
		if (result == 1) {
			st.close();
			st = null;
			return true;
		}
		return false;
	}*/
	
	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		try {
			bdao.setConnection();
			bdao.insertBoard();
			bdao.updateBoard();
			bdao.deleteBoard();
//			bdao.selectBoard();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
