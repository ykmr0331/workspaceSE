package dao.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.common.DataSource;

/*
 * Dao(Data Access Object) 클래스
 * 	 -  address 테이블에 CRUD(Create,Read,Update,Delete)작업을하는 
 *      단위메쏘드를 가지고있는 클래스	
 */
public class AddressDao {
	/*
	 * DataSource객체를 멤버필드로가짐
	 * (Connection을 생성하고 해지하는객체)
	 */
	private DataSource dataSource;
	public AddressDao() throws Exception{
		dataSource=new DataSource();
	}
	
	public int insert(Address insertAddress) throws Exception{
		String insertSql="insert into address values(address_no_seq.nextval,?,?,?)";
		//?,?,?: 두 번째, 세 번째, 네 번째 열에 해당하는 값을 나타내는 매개변수 위치 표시자입니다. ?는 나중에 실행 시점에 실제 값으로 대체됩니다.
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1,insertAddress.getName());
		pstmt.setString(2,insertAddress.getPhone());
		pstmt.setString(3,insertAddress.getAddress());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public int updateByPrimaryKey(Address updateAddress) throws Exception{
		String updateSql = "update address set name=? ,phone=?,address=? where no = ?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1,updateAddress.getName());
		pstmt.setString(2,updateAddress.getPhone());
		pstmt.setString(3,updateAddress.getAddress());
		pstmt.setInt(4,updateAddress.getNo());
		int rowCount=pstmt.executeUpdate();
		dataSource.close(con);
		return rowCount;
	}
	public int deleteByPrimaryKey(int no) throws Exception {

		String deleteSql = "delete from address where no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Address findByPrimaryKey(int no) throws Exception {
		Address findAddress=null;
		String selectSql = "select no,name,phone,address from address where no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1,no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			findAddress=new Address(number, name, phone, address);
		} 
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findAddress;
	}

	public ArrayList<Address> findAll() throws Exception {
		ArrayList<Address> addressList=new ArrayList<Address>();
		
		String selectSql = "select no,name,phone,address from address order by no";
		Connection con=dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			Address tempAddress=new Address(no, name, phone, address);
			addressList.add(tempAddress);
		} 
		rs.close();
		stmt.close();
		dataSource.close(con);
		return addressList;
	}
	

}