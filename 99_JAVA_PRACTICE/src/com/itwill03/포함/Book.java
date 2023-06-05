package com.itwill03.포함;
/*
 * - 캡슐화하세요
 * - 생성자를 정의하세요
 * 
 * <<속성>>
 *  책번호
 *  책제목
 *  책분류
 *  책설명
 * 
 * <<기능>>
 *   책정보출력
 *   
 */
public class Book {

	private int bookNumber;
	private String bookName;
	private String bookClassification;
	private String bookExplanation;
	
	
//생성자 정의
	public Book() {

	}

	public Book(int bookNumber, String bookName, String bookClassification, String bookExplanation) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookClassification = bookClassification;
		this.bookExplanation = bookExplanation;
	}


//getter setter


	public String getBookName() { // 회원의 회원정보출력메소드 사용시 필요
		return bookName;
	}



	


//책정보 출력
	public void print() {
		System.out.println("책번호: " + this.bookNumber);
		System.out.println("책이름: " + this.bookName);
		System.out.println("책분류: " + this.bookClassification);
		System.out.println("책설명: " + this.bookExplanation);
	}
	
	
}