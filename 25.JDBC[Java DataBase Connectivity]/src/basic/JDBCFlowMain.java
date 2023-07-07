package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception{
		/************데이타베이스 접속정보************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		String selectSql = "select * from dept";
		/*
		String driverClass="";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user="jdeveloper00";
		String password="jdeveloper00";- 
		 */
		
		/*
		 * 1.Driver class loading
		 *   A.Driver Class객체생성
		 *   B.DriverManager에 드라이버객체등록
		 */
		Class.forName(driverClass); //Class.forName()은 클래스를 동적으로 로드(메모리를 읽는것)하기 위한 자바 리플렉션 API의 메서드
		System.out.println("1.Driver class loading");
		
		/*
		 * 2.Connection객체생성
		 *   - DB Server와 연결객체
		 */
		Connection con = DriverManager.getConnection(url,user,password);
						/*
						 *  Connection 인터페이스는 데이터베이스와의 연결을 나타내며, 
						 * 데이터베이스 서버와의 통신을 관리하고 SQL 쿼리를 실행하는 데 사용됩니다.
						 */
						 
						/*DriverManager.getConnection() 메서드는 
						  지정된 URL, 사용자 이름 및 암호를 사용하여 데이터베이스에 연결을 설정합니다.
						  이를 통해 데이터베이스와 상호 작용하고 쿼리를 실행하고 데이터를 가져올 수 있습니다.*/
		System.out.println("2.Connection객체생성:"+con);
		
		/*
		 * 3.Statement 객체 생성
		 * - SQL문 전송객체 생성
		 */
		Statement stmt = con.createStatement();
								/* 참조변수 con은 Connection 인터페이스임*/
								/*Statement 인터페이스 :데이터베이스에 SQL 문을 실행하기 위한 메서드를 정의하고,
																						결과를 처리하는 데 사용*/
								/* createStatement() : SQL 문을 실행하기 위한 Statement 객체를 생성*/
		System.out.println("3.Statement객체생성:" + stmt+"   <--Statement인터페이스의 객체임.");
	
		/*
		 * 4.SQL문 전송(select)
		 * 5.ResultSet객체얻기(select)
		 	
		 	----------------------------
		 	 DEPTNO  DNAME  	 LOC      
		 	----------------------------
		 	 10		ACCOUNTING	NEW YORK
			 20		RESEARCH	DALLAS
			 30		SALES		CHICAGO
			 40		OPERATIONS	BOSTON
		 * 
		 */
		ResultSet rs = stmt.executeQuery(selectSql);
								/*ResultSet은 JDBC(Java Database Connectivity)에서 쿼리 결과 집합을 나타내는 인터페이스*/
		
								/*stmt라는 Statement 객체를 사용하여 selectSql 변수에 저장된 SQL 쿼리를 실행하고, 그 결과로 ResultSet 객체를 반환*/		
		System.out.println("4,5. ResultSet객체얻기 select문 실행결과):" + rs);
		System.out.println("----------------------------");
		System.out.println(" DEPTNO  DNAME  	 LOC    ");
		System.out.println("----------------------------");
		while(rs.next()) { /*rs.next()는 ResultSet 객체에서 다음 행으로 커서를 이동시키는 메서드*/

//일단 scott사용자의 dept테이블임. 위에 있어			

			int deptno = rs.getInt("deptno"); //rs(ResultSet은 쿼리 결과 집합을 나타내는 인터페이스)
							/*rs.getInt(): ResultSet 객체에서 현재 행의 특정 열에 있는 정수 값을 가져오는 메서드*/
			String dname = rs.getString("dname");
							/*rs.getString(): ResultSet 객체에서 현재 행의 특정 열에 있는 문자열 값을 가져오는 메서드입니다.*/
			String loc = rs.getString("loc");
			
			System.out.println(deptno+"\t"+dname+"\t"+loc);
		}
		/*
		 * 6.연결객체(resource해지) close
		 */
		rs.close();		//ResultSet 객체의 close() 메서드를 호출하여 결과 집합을 닫습니다. 
		stmt.close();	//Statement 객체를 닫습니다. 당 Statement 객체가 사용한 리소스가 해제되고, 데이터베이스와의 연결이 끊어집니다.
		con.close();	//Connection 객체의 close() 메서드를 호출하여 데이터베이스 연결을 닫음. Connection 객체가 소유한 리소스를 해제하고, 데이터베이스와의 연결을 종료합니다. 		
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}