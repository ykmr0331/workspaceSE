package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardSelectAllMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		String selectSql = "select * from board";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			do {
				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				Date board_wday = rs.getDate("board_wday");
				int board_read_count = rs.getInt("board_read_count");
				System.out.println(board_no + "\t" + board_title + "\t" + board_content + "\t" + board_wday + "\t" + board_read_count);
			} while (rs.next());
		}else {
			System.out.println(">> 게시글 없음.");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}