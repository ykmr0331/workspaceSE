package scanner;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		 * main thread가 String을 키보드로부터 입력받기위해 대기(blocking)
		 */
		System.out.print("이름을 입력하세요:");
		String nameStr =scanner.next();
		System.out.print("국어점수를 입력하세요:");
		int kor = scanner.nextInt();
		System.out.print("영어점수를 입력하세요:");
		int eng = scanner.nextInt();
		System.out.print("수학점수를 입력하세요:");
		int math = scanner.nextInt();
		
		int tot=kor+eng+math;
		double avg=tot/3.0;
		System.out.println(nameStr+"\t"+kor+"\t"+math+"\t"+eng+"\t"+tot+"\t"+avg);
		
		
		

	}

}