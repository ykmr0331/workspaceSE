package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardUpdateByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";

		String UpdateSql = "Update into board(board_no,board_title,board_content) values(board_no_seq.nextval,'제목','내용입니다')";
		String updateSql=
				"update address set board_no='' ,phone='888-8888',address='서울시 강서구' where no = 1";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(UpdateSql);
		System.out.println(">> Update row count : " + rowCount);
	}

}