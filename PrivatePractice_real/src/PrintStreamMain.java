

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {
	/*
	 * PrintStream은 Java에서 출력 스트림을 다루는 클래스입니다. 이 클래스는 바이트 기반 출력 스트림인 OutputStream의
	 * 하위 클래스로, 다양한 유형의 데이터를 텍스트 형식으로 출력할 수 있는 기능을 제공합니다
	 */
	public static void main(String[] args) throws Exception {
		PrintStream pout = new PrintStream(new FileOutputStream("printStream.txt"));
		
		pout.print('A');
		pout.print('A');
		pout.print('B');
		pout.print(123);
		pout.print(true);
		pout.print("프린트스트림");
		pout.print("한줄");
		pout.print("두줄");
		pout.println();
        pout.println(124356789);
        pout.write('1');
        pout.write('2');
        pout.write('3');
        pout.write('4');
        pout.write('5');
        pout.write('6');
        pout.write('7');
        pout.write('8');
        pout.write('9');
        pout.write('\n');
        pout.println(true);	
        pout.write('t');
        pout.write('r');
        pout.write('u');
		
    }

}
