package com.itwill01.field;


/*
  #### 성적처리를 위한 필요한 학생객체를 만들기 위한 클래스
 */
public class Student {

	/*
	 * << 속성(멤버변수) >> 번호 이름 국어 영어 수학 총점 평균 평점 석차 << 기능(멤버메쏘드) >>
	 * 기본데이타입력,총점계산,평균계산,평점계산, 출력
	 */
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 멤버변수 선언
	int no;			// Student클래스의 멤버필드 번호 선언
	String name;	// Student클래스의 멤버필드 이름 선언
	int kor;		// Student클래스의 멤버필드 국어 선언
	int eng;		// Student클래스의 멤버필드 영어 선언
	int math;		// Student클래스의 멤버필드 수학 선언
	int tot;		// Student클래스의 멤버필드 총점 선언
	double avg;		// Student클래스의 멤버필드 평균 선언
	char grade;		// Student클래스의 멤버필드 평점 선언
	int rank;		// Student클래스의 멤버필드 석차 선언
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 멤버메쏘드 선언

	/*
	 * 기본데이타(번호,이름,국어,영어,수학)멤버변수에대입하는메쏘드
	 */
	void assignScore(int no, String name, int kor, int eng, int math) {//assignScore메서드 생성
		//외부에서 번호, 이름,국어점수,영어점수,수학점수를 받아오기 위해서 매개변수(파라미터)를 5개 선언
		this.no = no; // 매개변수no를 통해 외부에서 받아온 번호값을 Student클래스의 멤버필드 no에 대입
		this.name = name;// 매개변수name을 통해 외부에서 받아온 이름값을 Student클래스의 멤버필드 name에 대입
		this.kor = kor;// 매개변수kor를 통해 외부에서 받아온 국어점수값을 Student클래스의 멤버필드 kor에 대입
		this.eng = eng; // 매개변수eng를 통해 외부에서 받아온 영어점수값을 Student클래스의 멤버필드 eng에 대입
		this.math = math; //매개변수math를 통해 외부에서 받아온 수학점수값을 Student클래스의 멤버필드 math에 대입

		return; //void타입 메서드라  return이 필수는 아니다.
	}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	/*
	 * 총점계산메쏘드
	 */

	int totCalc() { //총합을 계산하기 위한 메소드
		this.tot = kor + eng + math; 
		// 초기화되어있는 국어,영어.수학의 멤버필드를 모두 더한 값을 멤버필드 tot에 대입, 초기화함
		int result = tot;		 // 멤버필드 tot를 변수result에 대입
		return result;			 // result 반환, int타입 메서드라 리턴 필수
	}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
	/*
	 * 평균계산메쏘드 여기서부터
	 */

	double avrCalc() { // 리턴되는 값이 double이므로 메서드 타입은 double이다.
		this.avg = tot / (double) 3; // 이전에 
		//멤버필드 avg의 값이 실수로 나올 수 있기에 형변환을 위해서 나눠지는 3의 타입을 double로 변환함
		double result = this.avg;// 멤버필드 avg의 값을 result에 대입 
		return result;  // result 반환, double타입 메서드라 리턴 필수
	}

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	/*
	 * 평점계산메쏘드 평균이 들어가야
	 */

	char graCalc() {
			if(avg >=90 && avg <=100 ) {
				//System.out.println("학점은 A입니다.");
				this.grade = 'A';
			} else if (avg >=80) {
				//System.out.println("학점은 B입니다.");
				this.grade = 'B';
			} else if (avg >=70) {
				//System.out.println("학점은 C입니다.");
				this.grade = 'C';	
			} else if (avg >=60) {
				//System.out.println("학점은 D입니다.");
				this.grade = 'D';
			} else {
				//System.out.println("학점은 F입니다.");
				this.grade = 'F';
			}
			return this.grade;
	}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ		
		/*
		 * 출력메쏘드
		 */
		void print() {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ학생 데이터 출력ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.printf(" %s %s %5s %s %4s %s %s %6s %4s\n", "번호","이름","국어","영어","수학","총점","평균","평점","석차");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.printf(" %2d %5s %5d %5d %5d %5d %5.1f %5c %5d", this.no,this.name,this.kor,this.eng,this.math,this.tot,this.avg,this.grade,this.rank);
		}


	
	
	
	
}
	