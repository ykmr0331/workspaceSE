

public class MathMain {

	public static void main(String[] args) {
		/*
		 * Math 클래스
		 * -수학계산함수를 가지고 있는 클래스
		 * -모든 메서드 static메서드임
		 * -객체생성이 불가능(생성자 접근제한자가 private이다.)
		 	https://docs.oracle.com/javase/8/docs/api/index.html
		 */
		/*
		Math math = new Math();
		*/
		
		double r =Math.abs(-127.421);
		System.out.println(r);
		System.out.println(Math.max(999, 888));
		System.out.println(Math.max(999, 888));
		System.out.println(Math.round(33.5555555));
		System.out.println(Math.round(33.5555555*10)/10.0);
		System.out.println(Math.sqrt(2));
		System.out.println(Math.sqrt(3));
		System.out.println(Math.sqrt(4));
		System.out.println(Math.pow(2,3));// 2의 7승이라는 뜻
		System.out.println("--------Math.random()-----------");
		System.out.println(Math.random());
		/*
		 <<public static double random()>>
			Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
			0.0 이상 1.0 미만인 양의 부호를 가진 double 값을 반환합니다
		 */
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println("1~10사이의 정수 5개랜덤생성");
		System.out.println((int)( Math.random() * 10 + 1));
		System.out.println((int)( Math.random() * 10 + 1));
		System.out.println((int)( Math.random() * 10 + 1));
		System.out.println((int)( Math.random() * 10 + 1));
		System.out.println((int)( Math.random() * 10 + 1));
		
		System.out.println("1~45사이의 정수 6개랜덤생성");

		System.out.println((int)( Math.random() * 45 + 1));
		System.out.println((int)( Math.random() * 45 + 1));
		System.out.println((int)( Math.random() * 45 + 1));
		System.out.println((int)( Math.random() * 45 + 1));
		System.out.println((int)( Math.random() * 45 + 1));
		System.out.println((int)( Math.random() * 45 + 1));
	}

}
