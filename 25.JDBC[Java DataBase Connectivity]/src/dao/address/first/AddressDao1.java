package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
DAO를 사용하는 이유:

중복 코드 제거
데이터 액세스 로직의 추상화
유지 보수성과 테스트 용이성
데이터베이스 독립성
*/
public class AddressDao1 {
	
	String driverClass="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	public void insert() throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,'김경호','123-3456','경기도 포천시')";
		Class.forName(driverClass);
		//Class.forName()은 클래스를 동적으로 로드(메모리를 읽는것)하기 위한 메서드
		Connection con = DriverManager.getConnection(url, user, password);
		/*
		 *  Connection 인터페이스는 데이터베이스와의 연결, 
		 * 데이터베이스 서버와의 통신을 관리하고 SQL 쿼리를 실행하는 데 사용됨
		 */
		Statement stmt = con.createStatement();
			//Statement 인터페이스 :데이터베이스에 SQL 문을 실행하기 위한 메서드를 정의하고,결과를 처리하는 데 사용됌
			//createStatement() : SQL 문을 실행하기 위한 Statement 객체를 생성
		int rowCount = stmt.executeUpdate(insertSql);
			//executeUpdate() 메서드 Statement 인터페이스의 메소드로 INSERT, UPDATE, DELETE와 같은 데이터 조작 언어(DML) 문을 실행할 때 사용됩니다.
		System.out.println(">> insert row count:" + rowCount);
	}

	
	
	
	public void updateByPrimaryKey() throws Exception {

		String updateSql = "update address set name='김변경' ,phone='888-8888',address='서울시 강서구' where no = 1";
		Class.forName(driverClass);// 맨위에 있는거 String driverClass="oracle.jdbc.OracleDriver";  이거임
		Connection con = DriverManager.getConnection(url, user, password);
			//Connection 인터페이스: 데이터베이스 서버와의 통신을 관리하고 SQL 쿼리를 실행하는 데 사용됨
		Statement stmt = con.createStatement();
			//Statement 인터페이스 :데이터베이스에 SQL 문을 실행하기 위한 메서드 정의하고,결과를 처리하는 데 사용됌
		int rowCount = stmt.executeUpdate(updateSql);
			//executeUpdate() 메서드 Statement 인터페이스의 메소드로  데이터 조작 언어(DML) 문을 실행할 때 사용됌
		System.out.println(">> update row count:" + rowCount);
	}

	
	
	
	public void deleteByPrimaryKey() throws Exception { // pk 인 데이터 찾기

		String deleteSql = "delete from address where no=6";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
			//Connection 인터페이스: 데이터베이스 서버와의 통신을 관리하고 SQL 쿼리를 실행하는 데 사용됨
		Statement stmt = con.createStatement();
			//Statement 인터페이스 :데이터베이스에 SQL 문을 실행하기 위한 메서드를 정의하고,결과를 처리하는 데 사용됌
		int rowCount = stmt.executeUpdate(deleteSql);
			//executeUpdate() 메서드 Statement 인터페이스의 메소드로  데이터 조작 언어(DML) 문을 실행할 때 사용됌
		System.out.println(">> delete row count:" + rowCount);
	}

	
	
	
	public void findByPrimaryKey() throws Exception {

		String selectSql = "select no,name,phone,address from address where no=1";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
			///*ResultSet은 JDBC에서 쿼리 결과 집합을 나타내는 인터페이스
		if (rs.next()) { /*rs.next()는 ResultSet 객체에서 다음 행으로 커서를 이동시키는 메서드*/
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no + " " + name + " " + phone + " " + address);
		} else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();
	}

	
	
	
	public void findAll() throws Exception {

		String selectSql = "select no,name,phone,address from address order by no";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(no + " " + name + " " + phone + " " + address);
			} while (rs.next());
		} else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}