package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */
public class MemberDao {
	/*
	 * Dao 객체는멤버변수로 Connection을 생성하는 DataSource객체를 가짐
	 */
	private DataSource dataSource;

	public MemberDao() throws Exception {
		this.dataSource = new DataSource();
	}
	
	public int insert(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
		pstmt.setString(1, member.getmId());
		pstmt.setString(2, member.getmPassword());
		pstmt.setString(3, member.getmName());
		pstmt.setString(4, member.getmAddress());
		pstmt.setInt(5, member.getmAge());
		pstmt.setString(6, member.getmMarried());
		int rowCount = pstmt.executeUpdate();
		dataSource.close(con);
		pstmt.close();
		return rowCount;
	}
	
	public int update(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1,member.getmPassword());
		pstmt.setString(2,member.getmName());
		pstmt.setString(3,member.getmAddress());
		pstmt.setInt(4,member.getmAge());
		pstmt.setString(5,member.getmMarried());
		pstmt.setString(6,member.getmId());
		int rowCount = pstmt.executeUpdate();
		dataSource.close(con);
		pstmt.close();
		return rowCount;
	}
	
	public int delete(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);
		pstmt.setString(1,member.getmId());
		int rowCount = pstmt.executeUpdate();
		dataSource.close(con);
		pstmt.close();
		return rowCount;
	}
	
	
	
	public Member findByPrimaryKey(String id) throws Exception {
		Member exMember = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FIND_BY_PRIMARY_KEY);
		pstmt.setString(1,id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			exMember = new Member(rs.getString("m_id"),
								  rs.getString("m_password"),                    		
								  rs.getString("m_name"),                        		
								  rs.getString("m_address"),	                     		
								  rs.getInt("m_age"),	                         		
								  rs.getString("m_married"),                     		
								  rs.getDate("m_regdate") );                     				
		}
		dataSource.close(con);
		pstmt.close();
		return exMember;
	}
		
	
	public List<Member> findAll() throws Exception {
		List<Member> memberList = new ArrayList<Member>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FIND_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			memberList.add(new Member(rs.getString("m_id"),
					  rs.getString("m_password"),                    		
					  rs.getString("m_name"),                        		
					  rs.getString("m_address"),	                     		
					  rs.getInt("m_age"),	                         		
					  rs.getString("m_married"),                     		
					  rs.getDate("m_regdate") )
					);  
			
		}
		
		
		return memberList;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
}


