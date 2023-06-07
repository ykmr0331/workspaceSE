package com.itwill03.포함;

import javax.sound.midi.SysexMessage;

public class BookMember {
	/*
	 * - 캡슐화
	 * 
	 * <<속성>> 회원번호 회원이름 전화번호 빌린책
	 */

	private int memberNumber;
	private String memberName;
	private String memberPhoneNumber;
	private Book[] books;// 여기서 참조변수가 들어가는거

	// 생성자

	public BookMember(int memberNumber, String memberName, String memberPhoneNumber) {
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;

	}

	public BookMember() {

	}

	// getter setter------------------------------

	public void setBooks(Book[] books) {
		// 메인메서드에서 책객체참조변수를 회원의 멤버변수에 대입 시 필요
		this.books = books;
	}

	public Book[] getBooks() {
		return books;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	// getter setter------------------------------끝

	/*
	 * <<기능>> 회원정보출력
	 */
	public void print() {
//		System.out.println("회원번호: " + this.memberNumber);
//		System.out.println("회원이름: " + this.memberName);
//		System.out.println("전화번호: " + this.memberPhoneNumber);
		
		System.out.println("회원번호: " + memberNumber + "번\t회원이름: " + memberName + "\t회원전화번호: " + memberPhoneNumber);
		if(books == null) {
			System.out.println("빌린책 없음");
		} else {
			for (int i = 0; i < books.length; i++) {
				books[i].print();
			}
		}
		System.out.println();
	}
	

	
	
}