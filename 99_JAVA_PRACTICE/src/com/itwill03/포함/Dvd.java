package com.itwill03.포함;


	/*
	 * - 캡슐화하세요
	 * - 생성자를 정의하세요
	 * 
	 * <<속성>>
	 *  번호
		타이틀
		쟝르
	 * 
	 * <<기능>>
	 *   Dvd정보출력
	 *   
	 */
public class Dvd {
	/* <<속성>> 
		번호
		타이틀
		쟝르*/
	private int number;
	private String title;
	private String genre;
	
	
	
	//생성자 정의
	
	public Dvd() {

	}
	
	public Dvd(int number, String title, String genre) {
		super();
		this.number = number;
		this.title = title;
		this.genre = genre;
	}

	

	//getter setter
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
	
	
}