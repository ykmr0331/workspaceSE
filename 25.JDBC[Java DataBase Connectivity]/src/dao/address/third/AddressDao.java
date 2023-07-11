package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Dao(Data Access Object) 클래스
 * 	 -  address 테이블에 CRUD(Create,Read,Update,Delete)작업을하는 
 *      단위메쏘드를 가지고있는 클래스	
 * 
 * -DAO 클래스의 단위 메소드는 데이터베이스나 파일 시스템과의 상호작용을 통해
 *       특정한 작업을 수행하는 메소드
 */
public class AddressDao {


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
	
	
	public int insert(String name,String phone,String address) throws Exception {
		/*코드에서 제공된 insert 메소드는 주소록에 새로운 주소를 추가하는 작업을 수행하고, 
		   그 결과로 삽입된 행(row)의 개수를 반환하는 int 타입의 값을 반환*/
		String insertSql = 
				"insert into address values(address_no_seq.nextval,'"+name+"','"+phone+"','"+address+"')";
		Connection con=this.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		//System.out.println(">> insert row count:" + rowCount);
		stmt.close();
		this.close(con);
		return rowCount;
	}

	
	public int insert(Address insertAddress) throws Exception{ // 이건 객체를 넣어주는거다.
		String insertSql = "insert into address values(address_no_seq.nextval,?,?,?)";
		/*insert 메소드의 인자로 전달된 name, phone, address 값이 순서대로 위치 표시자에 대입된다.*/
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertAddress.getName());
		pstmt.setString(2, insertAddress.getPhone());
		pstmt.setString(3, insertAddress.getAddress());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		this.close(con);
		return rowCount;
	}
	
	
	public int updateByPrimaryKey(int no,String name,String phone,String address) throws Exception {
		String updateSql = "update address set name=? ,phone=?,address=? where no = ?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
			/*prepareStatement() 메소드는 SQL 문을 인자로 받으며, 
			  이 SQL 문에는 매개변수 위치 표시자(placeholder)가 포함될 수 있습니다.*/
		pstmt.setString(1, name);
			/* SQL 문의 매개변수 위치 표시자(placeholder)에 문자열 데이터를 설정하는 메소드입니다. 
			  매개변수 위치 표시자는 ?와 같은 형태로 SQL 문 내에 존재하며, 나중에 실행 시점에 실제 값으로 대체됩*/
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, no);
		int rowCount = pstmt.executeUpdate();
			/*DML쿼리를 실행하여 데이터베이스에서 영향을 받는 행(row)의 수를 반환하는 메소드임*/
		//System.out.println(">> update row count:" + rowCount);
		pstmt.close();
		this.close(con);
		return rowCount;
	}

	public int updateByPrimaryKey(Address updateAddress) throws Exception{
		String updateSql = "update address set name=? ,phone=?,address=? where no = ?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		/*prepareStatement() 메소드는 SQL 문을 인자로 받으며, 
		  이 SQL 문에는 매개변수 위치 표시자(placeholder)가 포함될 수 있습니다.*/
		pstmt.setString(1, updateAddress.getName());
		/*SQL 문의 매개변수 위치 표시자(placeholder)에 문자열 데이터를 설정하는 메소드입니다. 
		  매개변수 위치 표시자는 ?와 같은 형태로 SQL 문 내에 존재하며, 나중에 실행 시점에 실제 값으로 대체됩*/
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		int rowCount = pstmt.executeUpdate();
		return rowCount;

	}
	
	
	public int deleteByPrimaryKey(int no) throws Exception {

		String deleteSql = "delete from address where no=?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		//System.out.println(">> delete row count:" + rowCount);
		pstmt.close();
		this.close(con);
		return rowCount;
	}

	public Address findByPrimaryKey(int no) throws Exception {
		Address findAddress = null;
		String selectSql = "select no,name,phone,address from address where no=?";
		Connection con=this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1,no);
		ResultSet rs = pstmt.executeQuery();
			/*preparedStatement 객체로부터 쿼리를 실행하고, 
			  결과 데이터를 조회하기 위한 ResultSet 객체를 반환하는 메소드*/
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			//System.out.println(number + " " + name + " " + phone + " " + address); // 반환받을거니까 이제 안씀
			findAddress = new Address(no,name,phone,address);
		}	
		rs.close();
		pstmt.close();
		this.close(con);
		return findAddress;
	}

	public ArrayList<Address> findAll() throws Exception { //여러개 반환 Collection ArrayList쓴다.
		/* 행의 하나의 데이터를 멤버변수라 생각하고, 행 한줄 자체가 객체이고, 
		  	그게 여러개이면 ArrayList를 쓴다고 생각하면 이해 쉬움*/
		ArrayList<Address> addressList = new ArrayList<Address>();
		String selectSql = "select no,name,phone,address from address order by no";
		Connection con=this.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			/*결과 집합(ResultSet)에서 다음 행으로 이동하고, 해당 행이 존재하는지 여부를 확인하는 메소드*/
			do {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Address tempAddress = new Address(no, name, phone, address);
				addressList.add(tempAddress);
				//System.out.println(no + " " + name + " " + phone + " " + address);  반환받을꺼니까 쓰지말도록
			} while (rs.next());
		} else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		this.close(con);
		return addressList; // 아무것도 없으면 null 이 아니라 사이즈 0인 arrayList가 나옴
	}


}