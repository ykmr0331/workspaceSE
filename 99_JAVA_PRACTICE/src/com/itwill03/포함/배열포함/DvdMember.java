package com.itwill03.포함.배열포함;




public class DvdMember {
	/*
	- 캡슐화
	<<속성>>
	회원번호
	회원이름
	전화번호
	빌린dvd
	 */
	
	
	private int no;            //회원번호
	private String memberName; // 회원 성함
	private String phoneNumber; // 회원 전화번호
	private Dvd[] rentDvd;    //회원이 빌린 dvd들 집합(Dvd배열 객체)
	
	
	
//생성자-----------------------------------
	public DvdMember(int no, String memberName, String phoneNumber) { 
		this.no = no;//받은 매개변수를 회원의 멤버변수인 회원번호로 저장
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

	public Dvd[] getRentDvd() {
		return rentDvd;
	}

	
	public void setRentDvd(Dvd[] rentDvd) {
		this.rentDvd = rentDvd;
	}

	/*
	<<기능>>
	  회원정보출력 
	 */
	public void print() {
		System.out.println("ㅡㅡㅡDvd 대여자의 정보ㅡㅡㅡ");
		System.out.println(this.no+"\t" + this.memberName+ "\t" + this.phoneNumber);
		System.out.println("ㅡㅡㅡ대여한 Dvd의 정보ㅡㅡㅡ");
		
		if(rentDvd == null) {
			System.out.println("빌린 Dvd는 없음");
		} else {
			for (int i = 0; i < rentDvd.length; i++) {
				rentDvd[i].print();
			}
		}

		
	}

	
	
	}
	

	
	/*
	- 캡슐화
	<<속성>>
	회원번호
	회원이름
	전화번호
	빌린dvd
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
