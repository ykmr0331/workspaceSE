package dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.address.DataSource;

public class BoardDao {
	private DataSource dataSource; // DataSource 객체 선언
	
	public BoardDao() throws Exception{ //생성자임
		
		dataSource=new DataSource(); // dataSource 객체를 만들어
		/* dataSource 객체는 jdbc.properties파일을 읽어서 데이타베이스 접속정보를 멤버필드에저장*/
	}
	

	public int insert(Board insertBoard) throws Exception{
		String insertSql="insert into board(board_no,board_title,board_content) values(board_no_seq.nextval,?,?)";
		//?,?,?: 두 번째, 세 번째, 네 번째 열에 해당하는 값을 나타내는 매개변수 위치 표시자입니다. ?는 나중에 실행 시점에 실제 값으로 대체됩니다.
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1,insertBoard.getBoard_title());
		pstmt.setString(2,insertBoard.getBoard_content());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int updateByBoardNo(int boardNo) throws Exception {
		String deleteSql = "update board set board_title='변경타이틀',board_content='변경content' where board_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(deleteSql);
		stmt.setInt(1, boardNo);
		int rowCount = stmt.executeUpdate();
		dataSource.close(con);
		stmt.close();
		return rowCount;
	}
	
	public int updateByBoardNo(Board updateBoard) throws Exception {
		String deleteSql = "update board set board_title=?,board_content=? where board_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(deleteSql);
		stmt.setString(1, updateBoard.getBoard_title());
		stmt.setString(2, updateBoard.getBoard_content());
		stmt.setInt(3, updateBoard.getBoard_no());
		int rowCount = stmt.executeUpdate();
		dataSource.close(con);
		stmt.close();
		return rowCount;
	}
	
	
	public int deleteByBoardNo(int boardNo) throws Exception {
		String deleteSql = "delete board where board_no = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(deleteSql);
		stmt.setInt(1, boardNo);
		int rowCount = stmt.executeUpdate();
		stmt.close();
		dataSource.close( con);
		return rowCount;
	}
	
	public Board selectByBoardNo(int boardNo) throws Exception{
		Board tempBoard = null;
		String selectSql = "select * from board where board_no = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement(selectSql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
		tempBoard = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		}
		
		dataSource.close(con);
		stmt.close();
		return tempBoard;
	}
	
	public ArrayList<Board> selectAll() throws Exception{
		ArrayList<Board> boardList = new ArrayList<Board>();
		String selectSql = "select * from board";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			int no = rs.getInt(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String wday = rs.getString(4);
			int readCount = rs.getInt(5);
			Board tempBoard = new Board(no, title, content, wday, readCount);
			boardList.add(tempBoard);
		}
		return boardList;
	}
	
	
}