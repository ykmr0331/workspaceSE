import java.util.Scanner;

/*첫째 줄에는 현재 시각이 나온다
  현재 시각은    시 A (0 ≤ A ≤ 23)              분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다.

  두 번째 줄에는 @@@@요리하는 데 필요한 시간 C @@@@ (0 ≤ C ≤ 1,000)가 분 단위로 주어진다. 
  
   (단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다. 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)
   
   
   
예제 입력 1 
14 30
20

예제 출력 1 
14 50

   
 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 
  */

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] strs = input.split(" ");
		int a;
		int b;
		int[] nums = new int[strs.length];
		
		
		for (int i = 0; i < strs.length; i++) {
			nums[i] =Integer.parseInt(strs[i]);
			
		}
		//두번째 줄을 어떻게 정의해야되는지
		// a(시) 를 
		//배열 nums는 2개 다 채워짐
		
		//첫번째 줄 2번째 숫자랑 두번째줄 숫자를 더했을 때 60이 넘으면 첫번째 줄 1번째 숫자에 1을 더하도록한다.
		//그리고 60이 넘으면 그 60이 넘은 수에서 60을 뺀 숫자를 분으로 나오도록 설정한다.
		
		//첫번째 수 두번째 수
	
		
		
		
		
		
		
		
	}
}