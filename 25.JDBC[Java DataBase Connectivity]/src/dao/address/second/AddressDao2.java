package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Dao(Data Access Object) 클래스
 * 	 -  address 테이블에 CRUD(Create,Read,Update,Delete)작업을하는 
 *      단위메쏘드를 가지고있는 클래스	
 * 
 * -DAO 클래스의 단위 메소드는 데이터베이스나 파일 시스템과의 상호작용을 통해
 *       특정한 작업을 수행하는 메소드
 */
public class AddressDao2 {


	/*
	 * 데이터베이스 설정정보를 이용해서 
	 * Connection 객체를 생성해서 
	 * 반환하는 역할을 하는 메소드
	 */
	

	public Connection getConnection() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		Class.forName(driverClass);
			//드라이버:  데이터베이스와 Java 프로그램 간의 통신을 중개하는 소프트웨어 모듈
		Connection con = DriverManager.getConnection(url, user, password);
			//getConnection(): 지정된 URL, 사용자 이름 및 암호를 사용하여 데이터베이스에 연결을 설정	
		return con;
	}
	
	
	/*
	 * Connection객체를 close하는메쏘드(????)
	 */
	public void close(Connection con) throws Exception {
		con.close();
	}
	
	
	
	
	
	public void insert(String name,String phone,String address) throws Exception {
		String insertSql = 
				"insert into address values(address_no_seq.nextval,'"+name+"','"+phone+"','"+address+"')";
		Connection con=this.getConnection();
				//4문장 url password등 쓰기 귀찮아서 getConnection() 메서드를 생성한거다.
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		this.close(con); //즉 같은 클래스에 있는 바로 위 close()메소드를 사용한다. 매개변수로 con(Connection 타입)이 들어간다.
	}

	public void updateByPrimaryKey(int no,String name,String phone,String address) throws Exception {

		String updateSql = "update address set name=? ,phone=?,address=? where no = ?";// no(pk)를 조건으로 한 업데이트
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
			//PreparedStatement인터페이스: JDBC에서 SQL 문을 미리 컴파일하여 데이터베이스에 반복적으로 실행하기 위한 기능을 제공
				//동일한 SQL 문을 반복해서 실행해야 하는 경우 성능과 보안 측면에서 이점
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, no);
		int rowCount = pstmt.executeUpdate();
			//PreparedStatement인터페이스의 executeUpdate()메소드: 
				//괄호 안에 인자를 직접 전달하지 않고, 미리 설정된 매개변수에 값을 할당하여 SQL 문을 실행
					//여기서는 updateSql
		System.out.println(">> update row count:" + rowCount);
		pstmt.close();
		this.close(con);
	}

	public void deleteByPrimaryKey(int no) throws Exception {

		String deleteSql = "delete from address where no=?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		System.out.println(">> delete row count:" + rowCount);
		pstmt.close();
		this.close(con);
	}

	public void findByPrimaryKey(int no) throws Exception {

		String selectSql = "select no,name,phone,address from address where no=?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1,no);
		ResultSet rs = pstmt.executeQuery();
			//executeQuery(): SQL 문을 실행하고 결과를 ResultSet으로 반환하는 메서드
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(number + " " + name + " " + phone + " " + address);
		} else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		pstmt.close();
		this.close(con);
	}

	public void findAll() throws Exception { //검색에 관련
		String selectSql = "select no,name,phone,address from address order by no";
		Connection con=this.getConnection();
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
		this.close(con);
	}

}