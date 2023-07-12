package dao.guest;
/*
 * String sql을 가지고 있는 클래스
 */
public class GuestSQL {
 	
	
	
	public static final String GUEST_INSERT = "insert into guest values(guest_guest_no_seq.nextval,?,sysdate,?,?,?,?)";

/*static은 클래스 수준에 속하는 정적 멤버를 선언하는 데 사용됩니다.           
정적 멤버는 객체의 인스턴스 생성 없이도 해당 멤버를 직접 클래스 이름으로 접근할 수 있습니다.          
    GuestSQL.Guest_INSERT 이런식으로              */	

	/*final은 변경할 수 없는 불변성을 가지는 요소를 선언하는 데 사용됩니다.*/	
	

	public static final String GUEST_UPDATE = "update guest set guest_name=?,guest_email=?,guest_homepage=?,guest_title=?, guest_content=? where guest_no=?";

	public static final String GUEST_DELETE = "delete from guest where guest_no=?";
	
	public static final String GUEST_SELECT_BY_NO= "select * from guest where guest_no=?";
			
	public static final String GUEST_SELECT_ALL= "select * from guest";
			
	
	
	
	
	
	
}
