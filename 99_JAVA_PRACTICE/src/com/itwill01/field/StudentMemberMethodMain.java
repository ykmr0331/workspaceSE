package com.itwill01.field;

public class StudentMemberMethodMain {
	public static void main(String[] args) {
		/*
		학생객체생성(3명)
		*/
		Student student1 = new Student(); // Student객체생성하고 객체의 주소값이 참조변수 student1에 저장
		Student student2 = new Student();
		Student student3 = new Student();
		

		/*
		 학생객체기본데이타(번호, 이름, 국어, 영어, 수학) 입력메쏘드호출(3명)
		 */
		student1.assignScore(1, "1번인", 98, 80, 70);
		/* assignScore()메소드는 매개변수를 5개 지정했고 ,각각의 타입에 맞게 5개의 리터럴 입력해서 
		   참조변수 student1에 저장한 주소의 객체에 매개변수 값을 저장한다. */
		student2.assignScore(2, "2번인", 97, 87, 77);
		student3.assignScore(3, "3번인", 96, 86, 76);
		
		
		/*
		 학생총점계산 메쏘드 호출(3명)
		 학생평균계산 메쏘드 호출(3명)
		 학생평점계산 메쏘드 호출(3명)
		 */
		
		student1.totCalc();/* 참조변수 student1에 저장한 주소의 객체에 있는 totCalc()메소드를 호출한다. */		   
		student2.totCalc();
		student3.totCalc();
		
		student1.avrCalc();	  
		student2.avrCalc();
		student3.avrCalc();
		
		student1.graCalc();
		student2.graCalc();
		student3.graCalc();
		
		/*
		 * 학생데이타 출력메쏘드 호출(3명)
		 */
		student1.print();
		System.out.println();
		System.out.println();
		student2.print();
		System.out.println();
		System.out.println();
		student3.print();

	}
}
