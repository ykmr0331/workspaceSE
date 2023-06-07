package com.itwill03.포함.배열포함;




public class Dvd {
	/* <<속성>> 
		번호
		타이틀
		쟝르*/
	private int number; //Dvd번호
	private String title;//Dvd제목
	private String genre;//Dvd장르
	
	
	
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
	
	public void print() {
		System.out.println(this.getNumber()+ "\t" + this.getTitle()+ "\t" +  this.getGenre());
	}
	
	
	
	
}