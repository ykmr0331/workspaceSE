
public class ConstructorMain {

	public static void main(String[] args) {
		System.out.println("----------------------c1----------------");
		/*
		 << new Constructor();>>
		 	1. Constructor 클래스로 객체생성
		 	2.생성자메소드(블록) 호출
		 	3.
		 */
		Constructor c1 = new Constructor();
		System.out.println("c1: " + c1);
		c1.print();
		
		System.out.println();
		Constructor c2 = new Constructor(7777,8888);
		c2.print();
	}

}
