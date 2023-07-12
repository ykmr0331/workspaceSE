package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - guest테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class GuestDao {
	/*
	 * Connection 생성해지객체
	 */
	
	private DataSource dataSource;

	public GuestDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
	public int insert(Guest guest) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		int rowCount = pstmt.executeUpdate();
		dataSource.close(con);
		return  rowCount;
	}
	
	public int deleteByGuestNo(int guestNo) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, guestNo);
		int rowCount=pstmt.executeUpdate();
		dataSource.close(con);
		return rowCount;
	}
	
	public int updateByGuestNo(Guest guest) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2,guest.getGuestEmail());
		pstmt.setString(3,guest.getGuestHomepage());
		pstmt.setString(4,guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		pstmt.setInt(6, guest.getGuestNo());
		int rowCount = pstmt.executeUpdate();
		dataSource.close(con);
		return rowCount;
	}
	
	public Guest findByGuestNo(int guestNo) throws Exception{
		Guest guest = null;

		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		pstmt.setInt(1, guestNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
		guest = new Guest(rs.getInt("guest_no"), 
							rs.getString("guest_name"),
							rs.getDate("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content"));
		}
		dataSource.close(con);
		pstmt.close();
		return guest;
	}
	
	public List<Guest> findByAll() throws Exception{
		List<Guest> guestList = new ArrayList<Guest>();
		Connection con  = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"), 
									rs.getString("guest_name"),
									rs.getDate("guest_date"),
									rs.getString("guest_email"),
									rs.getString("guest_homepage"),
									rs.getString("guest_title"),
									rs.getString("guest_content")
									)
					);

		
		
		
	}
		return guestList;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}