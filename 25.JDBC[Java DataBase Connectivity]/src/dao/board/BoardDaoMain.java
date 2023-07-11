package dao.board;

import java.util.ArrayList;

public class BoardDaoMain {

	
	/*
	 * insert
	 * selectAll
	 * selectByBoardNo
	 * deleteByBoardNo
	 * updateByBoardNo
	 */
	public static void main(String[] args) throws Exception {
		BoardDao boardDao = new BoardDao();
		Board board1 = new Board(0, "제목", "내용입니다.", null, 0);
		System.out.println();
		
		
		System.out.println("1. insert");
		int insert = boardDao.insert(board1);
		System.out.println(">>> insert row count : " + insert);
		System.out.println();
		
		
		System.out.println("2. selectAll");
		ArrayList<Board> boardList = boardDao.selectAll();
		System.out.println(boardList);
		System.out.println();
		
		
		System.out.println("3. selectByBoardNo");
		Board tempBoard = boardDao.selectByBoardNo(2);
		System.out.println(tempBoard);
		System.out.println();
		
		System.out.println("4. deleteByBoardNo");
		int delete = boardDao.deleteByBoardNo(3);
		System.out.println(">>> deleteByBoardNo row count : " + delete);
		System.out.println();
		
		System.out.println("5. updateByBoardNo");
		int update = boardDao.updateByBoardNo(4);
		System.out.println(">>> updateByBoardNo row count : " + update);
		System.out.println();

		Board updateBoard = new Board(5, "해외여행가고싶다.", "마이애미로", null, 0);
		update = boardDao.updateByBoardNo(updateBoard);
		System.out.println(">>> updateByBoardNo row count : " + update);
	}

}