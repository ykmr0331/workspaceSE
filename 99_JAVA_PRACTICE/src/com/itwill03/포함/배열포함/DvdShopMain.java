package com.itwill03.포함.배열포함;


public class DvdShopMain {

	public static void main(String[] args) {
		
		
		/*
		 * 회원객체생성
		 */
		DvdMember[] DvdMember = new DvdMember[3];
		DvdMember DvdMember1 = new DvdMember(1, "박정수", "010-1234-5678");
		DvdMember DvdMember2 = new DvdMember(2, "김정수", "010-0987-6543");
		DvdMember DvdMember3 = new DvdMember(3, "이정수", "010-1515-3535");
;
		/*
		 * Dvd객체생성
		 */
		Dvd[] dvd = new Dvd[3];
		Dvd dvd1 = new Dvd(1, "반지의제왕", "판타지");
		Dvd dvd2 = new Dvd(2, "라라랜드", "로맨스");
		Dvd dvd3 = new Dvd(3, "엑소시스트", "공포");
		
		
		
		
		/*
		 * 회원이Dvd을 대여
		 * 
		 * Dvd객체참조변수를 회원의 멤버변수에대입
		 */
		
		
		DvdMember[0] = DvdMember1;// 회원객체 배열에 회원객체의 참조변수 대입 
		DvdMember[1] = DvdMember2;
		DvdMember[2] = DvdMember3;
		
		
		dvd[0] = dvd1;// DVD객체 배열에 DVD객체의 참조변수 대입
		dvd[1] = dvd2;
		dvd[2] = dvd3;

	
		//회원1,2 2명만 3개 전부 대여하고, 회원3은 아예 대여안함
		for (int i = 0; i < DvdMember.length-1; i++) {
		    DvdMember[i].setRentDvd(dvd);// dvd는 배열객체의 참조변수다.
		}
		
		
		
		/*
		 * 회원정보출력(회원이빌린Dvd정보출력)
		 */
		for (int i = 0; i < DvdMember.length; i++) {
			DvdMember[i].print();
			System.out.println();
		}
	}

}