package com.itwill01.method;


public class CalculatorMain {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator(); 
		//Calculator클래스의 참조변수 myCalc를 만들고, 새로운 Calculator객체를 생성
		//새 Calculator객체의 주소값이 참조변수 myCalc에 저장되어있음
		
		int result =myCalc.add(50,10); 
		/* 참조변수 myCalc로 Calculator객체의 add()메소드를 호출한다. add()메소드는 매개변수가 int형 2개이므로 
		50과 10을 넣는다. 그 값을 int형 변수 result에 대입한다.*/ 
		System.out.println(result);	   
		
		result =myCalc.sub(50,10);
		System.out.println(result);
		
		double result2 =myCalc.div(50, 10); 
		//?????myCalc.div()메서드에서 반환하는 리턴값은 double이므로 변수의 타입도 double이 되어야 한다. 
		System.out.println(result2);
		
		result =myCalc.mul(50,10);
		System.out.println(result);

	}

}
