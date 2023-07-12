package dao.member;
/*
VO(Value Object),DTO(Data Transfer Object)
	- member 테이블 1개 row의 데이타의 값을 가지는객체
	- member 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- member 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
	/*
	이름         널?       유형            
	---------- -------- ------------- 
	M_ID       NOT NULL VARCHAR2(20)  
	M_PASSWORD          VARCHAR2(20)  
	M_NAME              VARCHAR2(50)  
	M_ADDRESS           VARCHAR2(100) 
	M_AGE               NUMBER(3)     
	M_MARRIED           CHAR(1)       
	M_REGDATE           DATE     
	 */

import java.sql.Date;

public class Member {
	private  String mId;
	private String mPassword;
	private String mName;
	private String mAddress;
	private int mAge;
	private String mMarried;
	private Date mRegdate;

	
	public Member() {

	}


	public Member(String mId, String mPassword, String mName, String mAddress, int mAge, String mMarried, Date mRegdate) {		
		this.mId = mId;
		this.mPassword = mPassword;
		this.mName = mName;
		this.mAddress = mAddress;
		this.mAge = mAge;
		this.mMarried = mMarried;
		this.mRegdate = mRegdate;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}


	public String getmPassword() {
		return mPassword;
	}


	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getmAddress() {
		return mAddress;
	}


	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}


	public int getmAge() {
		return mAge;
	}


	public void setmAge(int mAge) {
		this.mAge = mAge;
	}


	public String getmMarried() {
		return mMarried;
	}


	public void setmMarried(String mMarried) {
		this.mMarried = mMarried;
	}


	public Date getmRegdate() {
		return mRegdate;
	}


	public void setmRegdate(Date mRegdate) {
		this.mRegdate = mRegdate;
	}


	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPassword=" + mPassword + ", mName=" + mName + ", mAddress=" + mAddress
				+ ", mAge=" + mAge + ", mMarried=" + mMarried + ", mRegdate=" + mRegdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}