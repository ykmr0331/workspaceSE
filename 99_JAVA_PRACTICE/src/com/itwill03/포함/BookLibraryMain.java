package com.itwill03.포함;





public class BookLibraryMain {
	public static void main(String[] args) {
		
		
		/*
		 * 책객체생성
		 */
		Book[] book = new Book[3];
		Book book1 = new Book(1, "반지의제왕", "판타지소설", "저자: 톨킨");
		Book book2 = new Book(2, "토지", "사회문학소설", "이효석");
		Book book3 = new Book(3, "해리포터와 비밀의방", "판타지소설", "조앤롤링");
		book[0] = book1; // 책객체 배열에 책객체의 참조변수 대입 
		book[1] = book2;
		book[2] = book3;
		
		/*
		 * 회원객체생성
		 */
		BookMember[] bookMember = new BookMember[3];
		BookMember bookMember1 = new BookMember(1, "박정수", "010-1234-5678", book1);
		BookMember bookMember2 = new BookMember(2, "김정수", "010-0987-6543", book2);
		BookMember bookMember3 = new BookMember(3, "이정수", "010-1515-3535", book3);
		bookMember[0] = bookMember1;// 회원객체 배열에 회원객체의 참조변수 대입 
		bookMember[1] = bookMember2;
		bookMember[2] = bookMember3;
		
		/*
		 * 회원이 책들 대여

		 * 책객체참조변수를 회원의 멤버변수에대입
		 */
		for (int i = 0; i < bookMember.length; i++) {
		    bookMember[i].setBook(book[i]);
		}

		
		/*
		 * 회원정보출력(회원정보와 회원이 빌린책들 정보출력)
		 */

		
		for (int i = 0; i < bookMember.length; i++) {
			bookMember[i].print();
			System.out.println();
		}

		
		
	}
}