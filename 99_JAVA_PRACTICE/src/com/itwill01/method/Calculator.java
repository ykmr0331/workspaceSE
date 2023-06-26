package com.itwill01.method;


public class Calculator { //Calculator 클래스 생성
	/*
	 * 4개의 멤버메쏘드를 가짐
	 */

		/*
		 * - add( 두개의 정수를 매개변수로 받아서 더한 결과값을 반환)
		 * - sub( 두개의 정수를 매개변수로 받아서 뺀   결과값을 반환)
		 * - div( 두개의 정수를 매개변수로 받아서 나눈 결과값을 반환)
		 * - mul( 두개의 정수를 매개변수로 받아서 곱한 결과값을 반환)
		 */
	
	int add(int x, int y) { // add메소드 생성,  정수형 매개변수(파라미터) 2개를 외부에서 받아옴
		int result = x + y; // 받아온 파라미터 2개로 리턴할 result변수를 선언 및 초기화
		
		return result; //result를 리턴값으로 반환, 메소드가 void타입이 아니므로 return필수
	}
	
	int sub(int x, int y) {  // sub메소드 생성, 정수형 매개변수(파라미터) 2개를 외부에서 받아옴
		int result = x - y;  // 받아온 파라미터 2개로 리턴할 result변수를 선언 및 초기화
		
		return result; //result를 리턴값으로 반환, 메소드가 void타입이 아니므로 return필수
	}
	
	double div(int x, int y) { // div 메소드 생성, 정수형 매개변수(파라미터) 2개를 외부에서 받아옴
		double result = (double)x / y; // 매개변수 둘다 int형타입이므로 한쪽에 double타입으로 변환 후  	
									   // 리턴할 변수값에 대입			
		return result; //result를 리턴값으로 반환, 메소드가 void타입이 아니므로 return필수
	}
	
	int mul(int x, int y) { // mul 메소드 생성, 정수형 매개변수(파라미터) 2개를 외부에서 받아옴
		int result = x * y; // 받아온 파라미터 2개로 리턴할 result변수를 선언 및 초기화
		
		return result;  //result를 리턴값으로 반환, 메소드가 void타입이 아니므로 return필수
	}


}

