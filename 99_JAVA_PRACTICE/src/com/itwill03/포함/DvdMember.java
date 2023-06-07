package com.itwill03.포함;


public class DvdMember {
	/*
	- 캡슐화
	<<속성>>
	회원번호
	회원이름
	전화번호
	빌린dvd
	 */
	
	
	private int no;
	private String memberName;
	private String phoneNumber;
	private Dvd rentDvd;//빌린dvd
	
	
	
//생성자-----------------------------------
	public DvdMember(int no, String memberName, String phoneNumber) {
		this.no = no;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;

	}
	
	public DvdMember() {

	}

	
//getter setter-------------------------------------
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Dvd getRentDvd() {
		return rentDvd;
	}

	public void setRentDvd(Dvd rentDvd, Dvd rentDvd1, Dvd rentDvd2) {
		this.rentDvd = rentDvd;
		this.rentDvd = rentDvd1;
		this.rentDvd = rentDvd2;
	}
	
	public void setRentDvd(Dvd rentDvd, Dvd rentDvd1) {
		this.rentDvd = rentDvd;
		this.rentDvd = rentDvd1;
	}
	public void setRentDvd(Dvd rentDvd) {
		this.rentDvd = rentDvd;
	}

	/*
	<<기능>>
	  회원정보출력 
	 */
	public void print() {
		System.out.println("회원번호: " + this.no);
		System.out.println("회원이름: " + this.memberName);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("빌린DVD: " + this.rentDvd.getTitle());
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}