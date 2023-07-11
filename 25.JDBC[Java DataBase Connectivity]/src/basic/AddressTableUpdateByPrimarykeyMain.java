package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableUpdateByPrimarykeyMain {

	public static void main(String[] args) throws Exception{
		/*******데이타베이스 접속정보[182.237.126.19]************
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user="jdeveloper00";
		String password="jdeveloper00";
		*****************************************************/
		/*************************************************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		/************************************************/
		String updateSql=
				"update address set name='김변경' ,phone='888-8888',address='서울시 강서구' where no = 3";
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(update)
		 5.SQL문전송(update)결과 영향받은행의수 반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);//Class.forName()은 클래스를 동적으로 로드(메모리를 읽는것)하기 위한 자바 리플렉션 API의 메서드
		Connection con=DriverManager.getConnection(url, user, password);
									/*
									 *  Connection 인터페이스는 데이터베이스와의 연결을 나타내며, 
									 * 데이터베이스 서버와의 통신을 관리하고 SQL 쿼리를 실행하는 데 사용됩니다.
									 */
									 
									/*DriverManager.getConnection() 메서드는 
									  지정된 URL, 사용자 이름 및 암호를 사용하여 데이터베이스에 연결을 설정합니다.
									  이를 통해 데이터베이스와 상호 작용하고 쿼리를 실행하고 데이터를 가져올 수 있습니다.*/
		Statement stmt = con.createStatement();
									/* 참조변수 con은 Connection 인터페이스임*/
									/*Statement 인터페이스 :데이터베이스에 SQL 문을 실행하기 위한 메서드를 정의하고,
																							결과를 처리하는 데 사용*/
									/* createStatement() : SQL 문을 실행하기 위한 Statement 객체를 생성*/
		int rowCount = stmt.executeUpdate(updateSql);
								/* executeUpdate()는 Statement 객체를 사용하여 
								 * INSERT, UPDATE 또는 DELETE와 같은 DML(Data Manipulation Language) 문을 실행하고,
								 *  영향을 받은 행의 수를 반환하는 메서드
								 */
		/*
		Statement 를 사용한 SQL문전송
		int executeUpdate(String sql) throws SQLException
			- Executes the given SQL statement, 
				which may be an INSERT, UPDATE, or DELETE statement 
				or an SQL statement that returns nothing, 
				such as an SQL DDL statement.
		Parameters:
			sql - an SQL Data Manipulation Language (DML) statement, 
				 such as INSERT, UPDATE or DELETE; 
				 or an SQL statement that returns nothing, 
				 such as a DDL statement.
		Returns:
			either (1) the row count for SQL Data Manipulation Language (DML) statements 
			or (2) 0 for SQL statements that return nothing
		 */
		System.out.println(">> update row count:"+rowCount);
		
	}

}











