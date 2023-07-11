package com.itwill07.jdbc.basic;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardSelectByPrimaryKeyMain {

	public static void main(String[] args) throws Exception{
	  /*드라이버 클래스와 데이터베이스 연결정보를 설정*/
		String driverClass="oracle.jdbc.OracleDriver"; // 드라이버클래스
		String url="jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 URL
		String user="scott";//사용자명
		String password="tiger";//비밀번호
	  /* 여기까지*/
		
		String selectSql = "select * from board where board_no = 3";
			// selectSql변수에 조회할 게시글의 조건(oard_no = 3")을 담은 SQL문을 저장합니다.
		
		Class.forName(driverClass);//JDBC드라이버 클래스를 로드합니다.
		Connection con = DriverManager.getConnection(url,user,password);
			//데이터베이스와의 연결을 설정하고 관리하는 다양한 메서드를 제공
			//DriverManager.getConnection(url, user, password)를 호출하여 데이터베이스에 연결
		Statement stmt = con.createStatement();
			// JDBC에서 SQL 문을 실행하고 데이터베이스와 상호 작용하는 역할을 담당하는 객체
			//con.createStatement()을 호출하여 SQL 문을 실행할 Statement 객체를 생성
		ResultSet rs = stmt.executeQuery(selectSql);
			/* ResultSet 인터페이스는 JDBC를 통해 데이터베이스에서 쿼리 결과를 담고 관리하는 객체.
			   stmt.executeQuery(selectSql)을 사용하여 SQL 문을 실행하고, 
			  	결과를 담은 ResultSet 객체를 반환받음*/
		if (rs.next()) { //rs.next()를 호출하여 결과 집합에서 첫 번째 레코드로 이동
			do {	//ResultSet의 getInt() 등의 메서드를 사용하여 컬럼 값을 가져옴
				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				Date board_wday = rs.getDate("board_wday");
				int board_read_count = rs.getInt("board_read_count"); 
				System.out.println(board_no + "\t" + board_title + "\t" + board_content + "\t" + board_wday + "\t" + board_read_count);
			} while (rs.next());
		}else {
			System.out.println(">> 게시글 없음");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}