package com.itwill00.variable;
//@@@@@@@@@@@@@@  변수 이름의 첫글자는 소문자다~~~~~~~~~~~~~~~!!!!!!!!!!!!!
public class DuoMemberInfoPrint{

	public static void main(String[] args) {
		/*변수선언*/
		int Membership_number;//회원번호 변수 선언 
		String name;// 이름 변수 선언
		String Identification_number; // 주민번호 변수 선언
		char sex; //성별 변수 선언
		int NumOfMarriages;// 결혼횟수 변수 선언
		boolean Cigarette; // 흡연여부 변수 선언
		float height;	//키 변수 선언
		char grade;		//학점 변수 선언
		char Appearance;  //용모 변수 선언
		
		//변수에 데이터 대입
		Membership_number = 236514;  //회원번호 변수에 데이터 대입
		name = "홍길동";// 이름 변수에 데이터 대입
		Identification_number = "201212-3495039";// 주민번호 변수에 데이터 대입
		sex = '남'; //성별변수에 데이터 대입
		NumOfMarriages = 0;//결혼횟수 변수에 데이터 대입
		Cigarette= true; //흡연여부 변수에 데이터 데입
		height = 178.3f; //키 변수에 데이터 대입
		grade = 'A'; //학점 변수에 데이터 대입
		Appearance = '상'; //용모변수에 데이터 대입
		
		//변수 내용 출력
		System.out.println("***************************************************************************************");
		System.out.println("회원번호  이름 	  주민번호	 성별	 결혼횟수	 흡연여부	 키	 학점	 용모");
		System.out.println(+Membership_number+ "   " +name+ "   " +Identification_number+ "    " +sex+ "      " +NumOfMarriages+ "              " +Cigarette+ "          " +height+ "      " +grade+ "      "+ Appearance);
				// 위의 출력은 문자열 연결 연산자와 문자열 띄어쓰기로
		System.out.println("***************************************************************************************");
	}

}