package com.itwill03.포함.배열포함;

public class BookMember {
	/*
	- 캡슐화
	
	<<속성>>
	 회원번호
	 회원이름
	 전화번호
	 빌린책
	*/

	
	private int memberNumber;
	private String memberName;
	private String memberPhoneNumber;
	private Book[] book;// 여기서 참조변수가 들어가는거
	
	
	//생성자
	

	public BookMember(int memberNumber, String memberName, String memberPhoneNumber) {
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;

	}
	
	public BookMember() {

	}

	//getter setter------------------------------


	public void setBook(Book[] book) {
		//메인메서드에서 책객체참조변수를 회원의 멤버변수에 대입 시 필요
		this.book = book;
	}
	//getter setter------------------------------끝




	/*
	<<기능>>
	  회원정보출력 
	 */
	public void print() {
		System.out.println("회원번호: " + this.memberNumber+"번\t회원이름:" + this.memberName+ "\t전화번호: "+ this.memberPhoneNumber);
		if(book == null) {
			System.out.println("빌린 책 없음");
		} else {
			for (int i = 0; i < book.length; i++) {
				book[i].print();
			}
		}
		
	}

	
	
	
	
	
}