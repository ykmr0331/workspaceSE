package com.itwill00.variable;

public class StudentScorePrint {
	public static void main(String[] args) {
	/*
	 * 성적관리에서 학생2명 데이터를 담을 변수선언
	 * 	- 번호(int), 이름(String), 국어, 영어, 수학, 총점, 평균(double), 평점(A,B,C)(char), 석차(int)
	 */
		int stuNum1, stuNum2; //학생 2명의 학번 변수 생성
		String name1, name2; //학생 2명의 이름 변수 생성
		int kor1, kor2; //학생 2명의 국어점수 변수 생성
		int eng1, eng2; //학생 2명의 영어점수 변수 생성
		int math1, math2; //학생 2명의 수학점수 변수 생성
		int totalScore1, totalScore2; //학생 2명의 총점 변수 생성
		double average1, average2; //학생 2명의 평균 변수 생성
		char grade1, grade2; //학생 2명의 평점 변수 생성
		int rank1, rank2; //학생 2명의 석차 변수 생성
		 

 	
	/*
	 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학) 입력 
	 */
		stuNum1= 1; stuNum2= 2; //학생 2명의 번호 데이터 입력
		name1 = "김경호"; name2 = "김경수";//학생 2명의 이름 데이터 입력
		kor1 = 80; kor2 = 95;  //학생 2명의 국어점수 데이터 입력
		eng1 = 96; eng2 = 73;  //학생 2명의 영어점수 데이터 입력
		math1 = 78; math2 = 76;   //학생 2명의 수학점수 데이터 입력

	/*
	 * 학생2명의 국어, 영어, 수학점수의 유효성체크		  
	 *   - 100점이 넘는 수나 음수가 입력되면 메세지를 출력하고 return(프로그램종료)한다.
	 */
		if( (!(kor1 >=0 && kor1 <=100)) || (!(kor2 >=0 && kor2 <=100)) || (!(eng1 >=0 && eng1 <=100)) || (!(eng2 >=0 && eng2 <=100)) ||
				(!(math1 >=0 && math1 <=100)) || (!(math2 >=0 && math2 <=100)) ) { 
			//학생 2명의 국어, 영어, 수학 점수들 중 하나라도 1~100의 범위에서 벗어나면 프로그램 종료하도록
			System.out.println("잘못된 점수입니다.");
			return;
		}
		
		
		
	/*
	 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학)를 이용해서
	 * 총점, 평균,평점을 계산 후 대입 (평점은 F , 석차는 0을 대입)
	 */
		totalScore1 = kor1 + eng1 + math1 ; totalScore2 = kor2 + eng2 + math2; //기본데이터 이용해 학생 2명의 총점 입력
		average1 =  (float)totalScore1/3; average2 =  (float)totalScore2/3; // 총점 이용해서 학생 2명의 평균 입력
		grade1 = 'F'; grade2 = 'F';//학생 2명의 평점 초기화
		
		if(average1>=90) { //변수 average1을 가지고  if문을 이용해 grade1의 값을 구하기
			grade1 ='A';
		} else if (average1>=80) {
			grade1 = 'B';
		} else if (average1>=70) {
			grade1 = 'C';
		} else if (average1>=60) {
			grade1 = 'D';
		} else {
			grade1 = 'F';
		}
		
		if(average2>=90 && average2 <=100 ) { //변수 average2르 가지고  if문을 이용해 grade2의 값을 구하기
			grade2 ='A';
		} else if (average2>=80) {
			grade2 = 'B';
		} else if (average2>=70) {
			grade2 = 'C';
		} else if (average2>=60) {
			grade2 = 'D';
		} else {
			grade2 = 'F';
		}
		
		rank1 = 0; rank2 = 0; 	//학생 2명의 석차 입력
	
		
		
		
		
		/*
		- 출력포맷
 		- 평균은 소수점이하 첫째자리까지출력(반올림)
 		- 석차는 구하지마세요
		--------------학생 성적출력-------------------
		학번  이름   국어 영어 수학 총점 평균 평점 석차
		-----------------------------------------------
		 1   김경호   42   56   78            F     0
		 2   김경수   45   53   76     		  F     0
 		-----------------------------------------------
		*/
		
		System.out.println("--------------학생 성적출력-------------------\n");
		System.out.println("학번  이름  국어 영어 수학 총점 평균 평점 석차\n");
		System.out.println("-----------------------------------------------\n");
		System.out.printf("%2d %5s %3d %3d %4d %5d %5.1f %4c %4d\n", stuNum1, name1, kor1, eng1, math1, totalScore1, average1, grade1, rank1);
		System.out.printf("%2d %5s %3d %3d %4d %5d %5.1f %4c %4d\n", stuNum2, name2, kor2, eng2, math2, totalScore2, average2, grade2, rank2);
		System.out.println("-----------------------------------------------\n");
		
	}

}
