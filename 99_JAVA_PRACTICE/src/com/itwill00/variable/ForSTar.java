package com.itwill00.variable;

public class ForSTar {

	public static void main(String[] args) {
		System.out.println("1.---------------------------------------");
		/*
		 * ★[0,0]★[0,1]★[0,2]★[0,3]★[0,4] ★[1,0]★[1,1]★[1,2]★[1,3]★[1,4]
		 * ★[2,0]★[2,1]★[2,2]★[2,3]★[2,4] ★[3,0]★[3,1]★[3,2]★[3,3]★[3,4]
		 * ★[4,0]★[4,1]★[4,2]★[4,3]★[4,4]
		 * 
		 * ★★★★★ ★★★★★ ★★★★★ ★★★★★ ★★★★★
		 */

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%s[%d,%d]", "★", i, j);
			}
			System.out.print("\n");
		}
		
		
		
		/*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 과제: 다음과같이 출력하세요
		 */
		
		
		System.out.println("2.---------------------------------------");
		/*
		 * ☆★★★★ 
		 * ★☆★★★ 
		 * ★★☆★★ 
		 * ★★★☆★ 
		 * ★★★★☆
		 */
		for (int i = 1; i <= 5; i++) { //별표 5줄을 만들어야 하니까
			for (int j = 1; j <= 5; j++) { //별표 한 줄에 5칸이 들어가야하니까
				if(i ==j) {
					System.out.print( "☆");  //i열과 j열이 같을 때 비어있는 별표이므로 이렇게 작성
				} else {					
				System.out.print( "★");      //그 외의 경우는 별표로 작성
				}
			}                                
			System.out.print("\n");			//안쪽 for문을 벗어난다는것은 별표 한줄이 끝나는 것이므로 여기서 줄바꿈을 해줘야한다. 아직 바깥쪽 for문 안에 해당함
		}//바깥쪽 for문의 끝									
	
		
		System.out.println("3.---------------------------------------");//통과!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
		/*
		 * ★ 
		 * ★★ 
		 * ★★★ 
		 * ★★★★ 
		 * ★★★★★
		 */
		for (int i = 1; i <= 5; i++) { //별표 5줄을 만들어야 하니
			for (int j = 1; i >= j; j++) { //별표가 생기는 [i,j]를 생각해보자 [1,1],[2,1],[2,2],[3,1],[3,2],[3,3]... 
				System.out.print("★");          //System.out.printf("[%d,%d]★",i,j);  모르겠으면 ...
			}
			System.out.println();
		}
		
		System.out.println("4.---------------------------------------");//통과!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
		/*
		 * ★★★★★ 
		 * ★★★★ 
		 * ★★★ 
		 * ★★ 
		 * ★
		 */
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; i <= j; j--) { 
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("5.---------------------------------------"); 
		/*
		/*
		 * ★★★★★ 
		 * ☆★★★★ 
		 * ☆☆★★★ 
		 * ☆☆☆★★ 
		 * ☆☆☆☆★
		 */
		for(int i =0; i <5; i++) {
			for(int j =0; j < 5; j++) {
				if(i >j) { //비어있는 별표는 ij가 10, 20, 21, 30, 31, 32, 40, 41, 42, 43, 이렇게 되어있다.
					System.out.print("☆");      
				} else { 			//그 외의 경
					System.out.print("★");
				}

			}
			System.out.println();
		}

	}

}
