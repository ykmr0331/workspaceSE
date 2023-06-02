package com.itwill01.field;

public class CarMemberFieldMain {

	public static void main(String[] args) {
		/*
		 * 주차관리 프로그램시작
		 */
		Car car1 = new Car(); // Car클래스의 참조변수 car1을 만들고 Car객체를 생성한다.
							  // 새로운 Car객체의 주소가 참조변수 car1에 저장된다.
		
		/*
		 * 1.차량번호 1234 차량 12시입차
		 */
		car1.number = 1234; //참조변수 car1을 이용해서 Car객체로 가서 Car객체의 멤버변수 number를 초기화한다. 
		car1.inTime = 12;  //참조변수 car1을 이용해서 Car객체로 가서 Car객체의 멤버변수 inTime을 초기화한다.
		
		
		
		/*
		 * 2.car1차량 16시출차
		 */
		
		/*
		 * 2-1. 출차시간대입
		 */
		car1.outTime = 16; //참조변수 car1을 이용해서 Car객체로 가서 Car객체의 멤버변수 outTime을 초기화한다.
		
	
		/*
		 * 2-2.주차요금계산
		 */
		
		car1.fee = (car1.outTime - car1.inTime)*1000;
		// 위에서 outTime과 inTime의 값을 초기화 했으므로  식으로 초기화가 가능하다.
		
		/*
		 * 2-3.주차요금 영수증출력
		 */
		System.out.printf("------------------------------------\n");
		System.out.printf("%s %s %s %s\n","차량번호","입차시간","출차시간","주차요금");
		//출력 형식이 모두 문자열 타입이다.
		System.out.printf("------------------------------------\n");
		System.out.printf("%7s %7d %7d %9d",car1.number, car1.inTime, car1.outTime, car1.fee);
		// 각각의 멤버필드의 타입에 맞게 선언한 후 형식화된 문자열 출력
	
		
		
	}

}