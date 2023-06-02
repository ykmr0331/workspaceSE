package lang;

public class StringCompareMain {

	public static void main(String[] args) {
		System.out.println("-----------String객체 내용 비교는 반드시 equals메소드사용-----------");
		/*
		 * << public boolean equals(String otherString) >> -스트링객체의 문자열과 otherString객체의
		 * 문자열이 같은지 비교해서 true(같은경우),false(다른경우)를 반환한다.
		 */

		String name1 = "KIM";
		String name2 = "KIM"; ///여기서 "KIM"도 객체다 
							  //자바에서 문자열은 객체로 취급되며, String 클래스는 문자열을 조작하고 처리하기 위한 다양한 메서드와 기능을 제공합니다. 
		String name3 = "LIM";
		name1.equals(name2); // true임

		if (name1.equals(name2)) {
			System.out.println("name1객체의 문자열과 name2객체의 문자열이 동일하다.");
		}
		
		
		if(!name1.equals(name3)) {
			System.out.println("name1객체의 문자열과 name3객체의 문자열이 동일하지 않다.");
		}
		
		if(name1.equals("KIM")) {
			System.out.println("name1객체의 문자열과 \"KIM\"객체의 문자열이 동일하다.");
		}
		
		if(!name1.equals("SIM")) {
			System.out.println("name1객체의 문자열과 \"SIM\"객체의 문자열이 동일하지않다.");
		}
		
		
	}

}
