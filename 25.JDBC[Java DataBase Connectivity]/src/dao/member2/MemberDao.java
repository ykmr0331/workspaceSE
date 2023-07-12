package dao.member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	private dao.member2.DataSource dataSource;

	public MemberDao() throws Exception{
		dataSource = new dao.member2.DataSource();
		
	}
	public Member selectById(String memberId) throws Exception{
		Member member = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FIND_BY_PRIMARY_KEY);
		pstmt.setString(1, memberId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6).charAt(0), rs.getDate(7));
		}
		dataSource.close(rs, pstmt, con);
		return member;
	}
	
	
	public Member insert(Member member) throws Exception {
		Member insertMember = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
		pstmt.setString(1,member.getMemberID());
		pstmt.setString(2,member.getMemberPassword());
		pstmt.setString(3,member.getMemberName());
		pstmt.setString(4,member.getMemberAddress());
		pstmt.setInt(5,member.getMemberAge());
		pstmt.setString(6,String.valueOf(member.getMemberMarried()));
		pstmt.executeUpdate();
		dataSource.close(pstmt, con);
		insertMember = selectById(member.getMemberID());
		return insertMember;
		
	}
	
	
	public Member update(Member member) throws Exception {
		Member updateMember = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		pstmt.setString(1, member.getMemberPassword());
		pstmt.setString(2, member.getMemberName());
		pstmt.setString(3, member.getMemberAddress());
		pstmt.setInt(4, member.getMemberAge());
		pstmt.setString(5, String.valueOf(member.getMemberMarried()));
		pstmt.setString(6, member.getMemberID());
		pstmt.executeUpdate();
		dataSource.close(pstmt, con);
		updateMember = selectById(member.getMemberID());
		return updateMember;

	}
	
	
	public Member delete(String memberId) throws Exception {
		Member member = null;
		Connection con  = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);
		pstmt.setString(1, memberId);
		pstmt.executeUpdate();
		dataSource.close(pstmt, con);
		member = selectById(memberId);
		return member;

	}
	public List<Member> selectAll() throws Exception{
		List<Member> memberList = new ArrayList<Member>();
		Member member = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FIND_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6).charAt(0), rs.getDate(7));
			memberList.add(member);
		}
		dataSource.close(rs, pstmt, con);
		return memberList;
	}
	
	
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	



