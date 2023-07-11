package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountSelectByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass="oracle.jdbc.OracleDriver"; // 드라이버클래스
		String url="jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 URL
		String user="scott";//사용자명
		String password="tiger";//비밀번호
		
		String selectSql = "select * from account where no = 11";

		Class.forName(driverClass);//JDBC드라이버 클래스를 로드합니다.
		Connection con = DriverManager.getConnection(url,user,password);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(selectSql);

		if (rs.next()) { //rs.next()를 호출하여 결과 집합에서 첫 번째 레코드로 이동
			do {	//ResultSet의 getInt() 등의 메서드를 사용하여 컬럼 값을 가져옴
				int no = rs.getInt("no");
				String owner = rs.getString("owner");
				int balance = rs.getInt("balance");
				int iyul= rs.getInt("iyul");

				System.out.println(no + "\t" + owner+ "\t" + balance + "\t" +iyul+ "\t");
			} while (rs.next());
		}else {
			System.out.println(">> 게시글 없음");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}
