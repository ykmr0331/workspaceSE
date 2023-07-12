package dao.board;
/*
VO(Value Object),DTO(Data Transfer Object)
	- board 테이블 1개 row의 데이타의 값을 가지는객체
	- board 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- board 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름               널?       유형             
---------------- -------- -------------- 
BOARD_NO         NOT NULL NUMBER(10)     
BOARD_TITLE               VARCHAR2(255)  
BOARD_CONTENT             VARCHAR2(4000) 
BOARD_WDAY                DATE           
BOARD_READ_COUNT          NUMBER(10)     
 */
public class Board {

	private int board_no;
	private String board_title;
	private String board_content;
	private String board_wday;
	private int board_read_count;
	
	public Board() {
	
	}

	public Board(int board_no, String board_title, String board_content, String board_wday, int board_read_count) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_wday = board_wday;
		this.board_read_count = board_read_count;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_wday() {
		return board_wday;
	}

	public void setBoard_wday(String board_wday) {
		this.board_wday = board_wday;
	}

	public int getBoard_read_count() {
		return board_read_count;
	}

	public void setBoard_read_count(int board_read_count) {
		this.board_read_count = board_read_count;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_wday=" + board_wday + ", board_read_count=" + board_read_count + "]";
	}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


