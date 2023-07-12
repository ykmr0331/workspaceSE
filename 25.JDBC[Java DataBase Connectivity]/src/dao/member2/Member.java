package dao.member2;
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
	private String memberID;
	private String memberPassword;
	private String memberName;
	private String memberAddress;
	private int memberAge;
	private char memberMarried;
	private Date memverRegDate;
	
	public Member() {
	}

	public Member(String memberID, String memberPassword, String memberName, String memberAddress, int memberAge,
			char memberMarried, Date memverRegDate) {
		super();
		this.memberID = memberID;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberAge = memberAge;
		this.memberMarried = memberMarried;
		this.memverRegDate = memverRegDate;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public char getMemberMarried() {
		return memberMarried;
	}

	public void setMemberMarried(char memberMarried) {
		this.memberMarried = memberMarried;
	}

	public Date getMemverRegDate() {
		return memverRegDate;
	}

	public void setMemverRegDate(Date memverRegDate) {
		this.memverRegDate = memverRegDate;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberAddress=" + memberAddress + ", memberAge=" + memberAge + ", memberMarried=" + memberMarried
				+ ", memverRegDate=" + memverRegDate + "]\n";
	}

	
	
}