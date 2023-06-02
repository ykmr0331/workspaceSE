package com.itwill02.constructor;

public class BMain {

	public static void main(String[] args) {
		B b =new B(); //- B객체생성
		
		
		//- B객체멤버변수2개(x,y)에 값대입
		
		b.x =100;
		b.y ="졸리군";
		
		//B객체멤버변수2개의 값출력
		System.out.println(b.x);
		System.out.println(b.y);
		
		// B객체멤버메쏘드2개호출(m1,m2)
		b.m1();
		b.m2();
		
	}	

}
