package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardInsertMain {

	public static void main(String[] args) throws Exception {
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";

		String insertSql = "insert into board(board_no,board_title,board_content)values(board_no_seq.nextval,'제목','내용입니다')";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(insertSql);
			/* executeUpdate(): Statement 또는 PreparedStatement 객체를 사용하여 SQL 문을 실행하고, 
			  			데이터베이스에서 영향을 받은 행의 수를 반환하는 메서드.
			   INSERT, UPDATE, DELETE와 같은 데이터 변경 SQL 문을 실행합니다.*/
		System.out.println(">> insert row count : " + rowCount);
	}

}